/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendaAuto;

import model.Venda;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mark_
 */
public class ExcluiObjetoVenda {

    public static void main(String[] args) {
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

        Transaction trans = session.beginTransaction();

        // Busca no banco de dados minha venda que tenha como cod de venda 1 
        Venda venda = (Venda) session.load(Venda.class, 2);

        //Exclui objetos da classe venda e os produtos associados a mesma
        session.delete(venda);

        trans.commit(); // salva no banco de dados

        session.close();
    }
}
