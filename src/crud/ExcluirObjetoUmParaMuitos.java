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
import model.Venda;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class ExcluirObjetoUmParaMuitos {

    public static void main(String[] args) {
        Configuration conf = new AnnotationConfiguration();
        conf.configure();

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

        Transaction trans = session.beginTransaction();

        /*Busca no banco de dados um objeto da classe Venda que tenha
o id=1 */
        Venda venda = (Venda) session.load(Venda.class, 1);

        /*Exclui o objeto da classe Venda. Se for definido o tipo ALL
na cascata entre Venda e Funcionários,
 o objeto da classe Funcionário que estiver associado à venda
também será excluído (caso não possua outras vendas vinculadas).
 Isso não é o ideal, por isso foram configurados os tipos de
cascata PERSIST e MERGE.*/
        session.delete(venda);

        trans.commit(); //confirma a transação excluindo o objeto do banco de dados 
        session.close();
    }
}
