/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

/**
 *
 * @author mark_
 */
import model.Produto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class AlterarObjeto {

    public static void main(String[] args) {
        Configuration conf = new AnnotationConfiguration();
        conf.configure();

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

        Transaction trans = session.beginTransaction();

        /* O método load carrega o objeto do banco de dados a partir
do id
         */
        Produto produto = (Produto) session.load(Produto.class, 1);
        /*
Carrega o produto que tem código igual a 1*/

        produto.setNome("Coca-cola Grande"); //altera o nome do produto 
        produto.setPreco(6.0);

        session.saveOrUpdate(produto);
        /*neste caso, o objeto será
atualizado e não inserido, porque foi carregado a partir do banco de
dados*/

        trans.commit();
        /*confirma a transação salvando o objeto no
banco de dados*/

        session.close();
    }
}
