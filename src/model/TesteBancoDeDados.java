/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author mark_
 */
public class TesteBancoDeDados {
    
    public static void main(String[] args)
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
     
        
        session.close();
    }
}
