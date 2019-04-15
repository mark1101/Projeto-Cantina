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
import model.Funcionario;
import model.Produto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class AdicionarObjeto {

    public static void main(String[] args) {
        Configuration conf = new AnnotationConfiguration();
        conf.configure();

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

        Transaction trans = session.beginTransaction();
        
        //cria um novo objeto da classe Produto
        Produto produto = new Produto();
        produto.setNome("Coca-cola");
        produto.setPreco(6.0);
   
       
        session.save(produto);
       
        
        /*salva o objeto na sessão do Hibernate
 se for usado o comando saveOrUpdate(), o Hibernate irá inserir
no banco de dados caso seja um novo objeto (new Produto())
 ou alterar se for um objeto já existente*/

        trans.commit(); //confirma a transação salvando o objeto no banco de dados 
        session.close();
    }
}
