package Library_Management_System.Dao;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Library_Management_System.Book;
import Library_Management_System.HibernateUtil;

public class BookDao {
	
	//update the records
	
	public void updateBooks(Book book) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Transaction transaction=null;
		
		try(Session session = factory.getCurrentSession()){
			transaction = session.beginTransaction();
	        
	        // Get the existing book from the database
	        Book existingBook = session.get(Book.class, book.getBooksid());
	        if (existingBook != null) {
	            // Update the quantity of the existing book
	            existingBook.setQnt(book.getQnt());
	            
	            // Save or update the modified book
	            session.saveOrUpdate(existingBook);
	        } else {
	            System.out.println("Book not found!");
	        }
	        
	        transaction.commit();
	        session.close();
	        
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        System.out.println(e);
	    }
	}

	
	//display the records by name
	
	public Book getbooks(String name) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Transaction transaction=null;
		Book book = null;
		try(Session session = factory.getCurrentSession()){
			transaction = session.beginTransaction();
			
			book=session.get(book.getClass(),name);
			
			transaction.commit();
			session.close();
		}catch(Exception e) {
			if(transaction !=  null) {
				transaction.rollback();
			}
			System.out.println(e);
		}
		return book;
	}
	
	 public void displayBookDetails(Book book) {
	        
	    }
	
	//list of books
	
	public List<Book> getAllbooks() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Transaction transaction=null;
		List<Book> books = null;
		try(Session session = factory.openSession()){
			transaction = session.beginTransaction();
			
			
			books=session.createQuery("from Book").list(); 
			
			transaction.commit();
			
			session.close();
		}catch(Exception e) {
			if(transaction !=  null) {
				transaction.rollback();
			}
		}
		return books;
	}
		
	//delete book
	
	public Book deleteBook(long id) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Transaction transaction=null;
		Book book = null;
		try(Session session = factory.getCurrentSession()){
			transaction = session.beginTransaction();
		    
		    
		    
			book=session.get(Book.class, id);
			
			session.delete(book);
			
			transaction.commit();
			session.close();
		}catch(Exception e) {
			if(transaction !=  null) {
				transaction.rollback();
			}
		}
		return book;
	}
}
