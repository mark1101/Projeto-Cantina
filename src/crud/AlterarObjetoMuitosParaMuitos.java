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

public class AlterarObjetoMuitosParaMuitos {

    public static void main(String[] args) {
        Configuration conf = new AnnotationConfiguration();
        conf.configure();

        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

        Transaction trans = session.beginTransaction();

        /*Busca no banco de dados uma venda que tenha código igual a
1*/
        Venda venda = (Venda) session.load(Venda.class, 6);

        /*Cria um objeto da classe Produto*/
        Produto produto1 = new Produto();
        produto1.setNome("Guaraná");
        produto1.setPreco(6.0);

        /*Altera a data/hora da venda*/
        venda.setDataHora(new Date());

        /*Exclui um produto da venda*/
        venda.getProdutos().remove(0);

        /*Adiciona outro produto na venda*/
        venda.getProdutos().add(produto1);
        /*Salva o objeto da classe Venda e, devido à cascata
configurada na classe Venda, salva os produtos associados e exclui da
venda o produto que foi removido*/
        session.merge(venda);

        trans.commit(); //confirma a transação salvando os objetos no banco de dados 
        session.close();
    }
}
