/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author itcrc
 */
public class UserDAO {
     Session s = null;
       Transaction tr = null;           
    public UserDAO(){
       s=  HibernateUtil.getSessionFactory().openSession();
         tr = s.beginTransaction();
    }
    public void SaveUser(User user){
                
                s.save(user);
                tr.commit();
                s.close();
                
    }
    
    
    
   public List<User> getAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();  // Get the current session
        Transaction transaction = null;
        List<User> users = null;

        try {
            transaction = session.beginTransaction();  // Start a transaction
            
            // Use HQL to fetch all users from the User class (NOT the table)
              Query query = s.createQuery("FROM User");  // This assumes User is the entity class

          users = query.list();
            
            
            transaction.commit(); // Commit the transaction
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback if there is an error
            }
            e.printStackTrace();
        } finally {
            session.close(); // Close the session
        }

        return users; // Return the list of users
    }
   
   
   
   
   
   //Searching Data 
   
   public List<User> sarchUser(String searchId){
       List<User> userlist = null;
       
       tr = s.beginTransaction();
       
       Query query = s.createQuery("FROM User WHERE fname = :fname ");
       query.setParameter("fname", searchId);
       
       userlist  =query.list();
       tr.commit();
       s.close();
       return userlist;
       
   }
   
}
    
        