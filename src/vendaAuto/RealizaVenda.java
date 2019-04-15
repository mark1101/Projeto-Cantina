/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendaAuto;

import java.util.Date;
import model.Funcionario;
import model.HibernateUtil;
import model.Produto;
import model.Venda;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author mark_
 */
public class RealizaVenda {

    public static void main(String[] args) {
        
        
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

        Transaction trans = session.beginTransaction();

        //cria um novo objeto da classe Produto
        Produto produto = new Produto();
        produto.setNome("Coca-cola 2L");
        produto.setPreco(6.0);
        //Cria outro produto para ser adicionado a minha venda
        Produto produto2 = new Produto();
        produto2.setNome("Picanha 2kg");
        produto2.setPreco(54.0);
        
        //Salva os produtos pois são novos dentro do meu banco de dados
        session.save(produto);
        session.save(produto2);
        
        //Adiciono um funcionario dentro do meu banco de dados
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Mark Willian");
        funcionario.setCargo("Atendente");
        session.save(funcionario);
        
        Venda venda = new Venda();
        venda.setDataHora(new Date());

        //Adiciona ligeiramente dois produtos dentro da minha venda
        venda.getProdutos().add(produto);
        venda.getProdutos().add(produto2);
        //Adiciona um funcionario responsavel pela minha venda
        venda.setFuncionario(funcionario);
        //Salva os itens associados a minha venda
        session.merge(venda);
        
        //Salva todas as minhas alteracoes dentro do banco de dados
        trans.commit();   
        session.close();
     
        
    }
}
