/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendaAuto;

import java.util.List;
import model.HibernateUtil;
import model.Venda;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author mark_
 */
public class MostraVenda {
    
    public static void main(String[] args)
    {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();

        List<Venda> vendaa = sessao.createQuery("from Venda").list();
        vendaa.forEach(venda ->{System.out.println(venda);});
        t.commit();
        sessao.close();
        //
        
    }
}
