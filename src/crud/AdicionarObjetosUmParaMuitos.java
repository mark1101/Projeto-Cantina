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

public class AdicionarObjetosUmParaMuitos {

    public static void main(String[] args) {
        Configuration conf = new AnnotationConfiguration();
        conf.configure();

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

        Transaction trans = session.beginTransaction();

        /*Cria um objeto da classe Funcionário*/
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Jão");
        funcionario.setCargo("Balconista");

        /*Cria um objeto da classe Venda*/
        Venda venda = new Venda();
        venda.setDataHora(new Date());

        /*Associa o objeto da classe Funcionário ao objeto da classe
Venda*/
        venda.setFuncionario(funcionario);

        /*Salva o objeto da classe Venda e, devido à cascata
configurada na classe Venda, salva o objeto da classe Funcionário*/
        session.merge(venda);

        trans.commit(); //confirma a transação salvando os objetos no banco de dados 
        
        
        session.close();
    }
}
