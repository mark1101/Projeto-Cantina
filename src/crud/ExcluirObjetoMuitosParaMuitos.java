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
import java.util.Date;
import model.Funcionario;
import model.Produto;
import model.Venda;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class ExcluirObjetoMuitosParaMuitos {

    public static void main(String[] args) {
        Configuration conf = new AnnotationConfiguration();
        conf.configure();

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

        Transaction trans = session.beginTransaction();

        /*Busca no banco de dados uma venda que tenha código igual a 1*/
        Venda venda = (Venda) session.load(Venda.class, 1);

        /*Exclui o objeto da classe Venda e os produtos associados*/
        session.delete(venda);

        trans.commit(); //confirma a transação

        session.close();
    }
}
