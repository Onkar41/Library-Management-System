package Library_Management_System.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Library_Management_System.Book;
import Library_Management_System.IssueBookTo;

public class IssuedToDao {

	//list of IssuedTo
	
		public List<IssueBookTo> getAllissue(){
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			Transaction transaction=null;
			List<IssueBookTo> to = null;
			try(Session session = factory.openSession()){
				transaction = session.beginTransaction();
				
				
				to=session.createQuery("from IssueBookTo").list(); 
				
				transaction.commit();
				
				session.close();
			}catch(Exception e) {
				if(transaction !=  null) {
					transaction.rollback();
				}
			}
			return to;
		}
		
		public IssueBookTo deleteto(long id) {
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			Transaction transaction=null;
			IssueBookTo ito = null;
			try(Session session = factory.getCurrentSession()){
				transaction = session.beginTransaction();
			    
			    
			    
				ito=session.get(IssueBookTo.class, id);
				
				session.delete(ito);
				
				transaction.commit();
				session.close();
			}catch(Exception e) {
				if(transaction !=  null) {
					transaction.rollback();
				}
			}
			return ito;
		}
}
