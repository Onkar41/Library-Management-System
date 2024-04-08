package Library_Management_System;



import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Library_Management_System.Dao.BookDao;
import Library_Management_System.Dao.IssuedToDao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import org.hibernate.HibernateException;
import org.hibernate.Session;


public class App 
{
    public static void main( String[] args )
    {
      
 

            int choice;
        do {
            System.out.println("1. Add Book");
           
            System.out.println("2. Issued Book");
            System.out.println("3. Display Books");
            System.out.println("4. Update Book Quantity");
            System.out.println("5. delete Book");
            System.out.println("6. Display IssueBook TO");
            System.out.println("7. Delete IssueBook To");
            
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                	
                	addbooks();  
                   
                    break;
                case 2:
                	issueBooks(); 
                    
                    break;
                case 3:
                    displayBooks();
                    System.out.println();
                    break;
                case 4:
                	
                	updateBookDetails();
                    break;
                case 5:
                   deleteBook();
                    break;
                case 6:
                    displayIssued();
                    System.out.println();
                    break;
                case 7:
                    deleteIssuedTo();
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

 
    }
    
    
    private static void deleteIssuedTo() {
    	
       Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter IssueId  : ");
		long iid=sc.nextLong();
		
		IssuedToDao issueDao = new IssuedToDao();

		issueDao.deleteto(iid);
		
	}


	private static void displayIssued() {
		
		try {
		    IssuedToDao issued = new IssuedToDao();
		    List<IssueBookTo> to = issued.getAllissue();
		    
		    System.out.println("IssuedTo Information:");
		    System.out.println("------------------");
		    System.out.printf("%-10s %-20s %-20s %-10s %-10s %-10s\n", "ID", "Name", "Address", "Phone No", "Books", "Issue Date");
		    System.out.println("---------------------------------------------------------------------------------------------------");

		    to.forEach(new Consumer<IssueBookTo>() {
		        @Override
		        public void accept(IssueBookTo issue) {
		            // Construct a string containing all the book titles
		            StringBuilder booksString = new StringBuilder();
		            for (IssuedBooks book : issue.getBooks()) {
		                booksString.append(book.getBookname()).append(", ");
		            }
		            
		            // Print the formatted output with book titles and issue date
		            System.out.printf("%-10d %-20s %-20s %-10s %-10s %-10s\n", 
		                issue.getI_Id(), issue.getName(), issue.getAddress(), issue.getPhoneNo(), booksString.toString(), issue.getIdate());
		        }
		    });
		} catch(Exception e) {
		    System.out.println("An error occurred: " + e.getMessage());
		}



		
	}


	private static void deleteBook() {
		
        Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter BookId  : ");
		long bid=sc.nextLong();
		
		BookDao bookDao = new BookDao();

		bookDao.deleteBook(bid);
		
	}


	private static void displayBooks() {
		
	    int choice;
        do {
            System.out.println("\n "+"   1. Display All Book");
           
            System.out.println("    2. Display Book By Id");
            System.out.println("    3. Exit");
            
            System.out.print("    Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    try {
                        BookDao bookDao = new BookDao();
                        List<Book> books = bookDao.getAllbooks();
                        
                        System.out.println("Books Information:");
                        System.out.println("------------------");
                        System.out.printf("%-10s %-20s %-10s %-10s %-10s %-30s \n", "ID", "Title", "Price", "quantity","Publish Year","Author");
                        System.out.println("---------------------------------------------------------------------------------------------------");
                        
                        books.forEach(new Consumer<Book>() {
                            @Override
                            public void accept(Book book) {
                                System.out.printf("%-10d %-20s %-10d %-10d %-10d %-30s\n", book.getBooksid(), book.getBookname(), book.getPrice(),book.getQnt(), book.getPyear(),book.getAuth());
                            }
                        });
                    } catch(Exception e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }            	
                   
                    break;
                case 2:
                	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            		Transaction transaction=null;
            		
            		try(Session session = factory.getCurrentSession()){
            			transaction = session.beginTransaction();
            			System.out.print("    Enter Book Id : ");
               
                        long id = sc.nextLong();
                        
                	    Book book = session.get(Book.class, id);
                	if (book != null) {
                		 System.out.println("Books Information:");
                         System.out.println("------------------");
                         System.out.printf("%-10s %-20s %-10s %-10s %-10s %-30s \n", "ID", "Title", "Price", "quantity","Publish Year","Author");
                         System.out.println("---------------------------------------------------------------------------------------------------");
        	           
                         System.out.printf("%-10d %-20s %-10d %-10d %-10d %-30s\n", book.getBooksid(), book.getBookname(), book.getPrice(),book.getQnt(), book.getPyear(),book.getAuth());
                         
        	        } else {
        	            System.out.println("Book not found.");
        	        }
            		}catch(Exception e) {
            			System.out.println("An error occurred: " + e.getMessage());
            		}
                	                     
                    break;
                case 3:
                    
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    
    }
    
    
	private static void issueBooks() {
    	 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
         
         Session session = factory.getCurrentSession();    
             session.beginTransaction();    
                        
   	 try {
            // Create and save an author with books
            IssueBookTo to = new IssueBookTo();
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter  name:");
            to.setName(sc.nextLine());
            
            System.out.println("Enter  Pno:");
            to.setPhoneNo(sc.nextLine());

            System.out.println("Enter Address:");
            to.setAddress(sc.next());
            
            LocalDate currentDate = LocalDate.now();

            // Define a custom date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            // Format the current date using the custom formatter
            String formattedDate = currentDate.format(formatter);
            to.setIdate(formattedDate);

            while (true) {
                IssuedBooks book = new IssuedBooks();

                System.out.println("Enter book name (type 'exit' to finish adding Issueto):");
                String bookName = sc.next();

                if ("exit".equalsIgnoreCase(bookName)) {
                    break;
                }

               

                book.setBookname(bookName);
                
                book.setTo(to);

                to.getBooks().add(book);
            }

            session.save(to);
            session.getTransaction().commit();
            System.out.println("IssuedTO and IssuedBooks saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            // Close resources
            session.close();
            factory.close();
        }
    }

		
	
	public static void addbooks() {

    	  SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
          
          Session session = factory.getCurrentSession();    
              session.beginTransaction();    
                         
    	 try {
             // Create and save an author with books
             Author author = new Author();
             Scanner sc = new Scanner(System.in);

             System.out.println("Enter author name:");
             author.setAuthname(sc.nextLine());

             System.out.println("Enter author location:");
             author.setLocation(sc.nextLine());

             while (true) {
                 Book book = new Book();

                 System.out.println("Enter book name (type 'exit' to finish adding books):");
                 String bookName = sc.nextLine();

                 if ("exit".equalsIgnoreCase(bookName)) {
                     break;
                 }
                 	
                 System.out.println("Enter publication year:");
                 int publicationYear = sc.nextInt();
                 System.out.println("Enter Price :");
                 int price = sc.nextInt();
                 System.out.println("Enter Quantity:");
                 int qnt = sc.nextInt();
                 sc.nextLine(); // consume the newline character
                 

                 book.setBookname(bookName);
                 book.setPyear(publicationYear);
                 book.setPrice(price);
                 book.setQnt(qnt);
                 book.setAuth(author);
                 

                 author.getBooks().add(book);
             }

             session.save(author);
             session.getTransaction().commit();
             System.out.println("Author and books saved successfully!");
         } catch (Exception e) {
             e.printStackTrace();
             session.getTransaction().rollback();
         } finally {
             // Close resources
             session.close();
             factory.close();
         }
     }
	
	public static void updateBookDetails() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter BookId of Book You want to Update Quantity : ");
		long bid=sc.nextLong();
		System.out.print("Enter Quantity : ");
		int qnt = sc.nextInt();
		// Assuming you have a Book object with the updated quantity
		Book updatedBook = new Book();
		updatedBook.setBooksid(bid); // Set the ID of the book you want to update
		updatedBook.setQnt(qnt); // Set the updated quantity

		// Create an instance of your DAO class
		BookDao bookDao = new BookDao();

		// Call the updateBooks method with the updated Book object
		bookDao.updateBooks(updatedBook);

   }
	
    }
    


  
