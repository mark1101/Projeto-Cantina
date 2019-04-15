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



public class AdicionarObjetoMuitosParaMuitos {

    public static void main(String[] args) {
        Configuration conf = new AnnotationConfiguration();
        conf.configure();

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

        Transaction trans = session.beginTransaction();

        /*Cria um objeto da classe Produto*/
        Produto produto1 = new Produto();
        produto1.setNome("Coca-cola");
        produto1.setPreco(6.0);

        /*Cria um objeto da classe Produto*/
        Produto produto2 = new Produto();
        produto2.setNome("Pizza Mussarela");
        produto2.setPreco(20.0);

        /*Cria um objeto da classe Venda*/
        Venda venda = new Venda();
        venda.setDataHora(new Date());

        /*Adiciona 2 produtos na venda*/
        venda.getProdutos().add(produto1);
        venda.getProdutos().add(produto2);

        /*Salva o objeto da classe Venda e, devido à cascata
configurada na classe Venda, salva os produtos associados*/
        session.merge(venda);

        trans.commit(); //confirma a transação salvando os objetos no banco de dados

        session.close();
    }
}
