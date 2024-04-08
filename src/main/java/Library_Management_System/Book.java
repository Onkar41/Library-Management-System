package Library_Management_System;

import javax.persistence.*;



@Entity

public class Book {
	  


		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "books_id")
	    private Long booksid;

	    @Column(name = "book_name")
	    private String bookname;
	    private int pyear;
	    private int qnt;
	    private int price;

	    
	    @ManyToOne
	    @JoinColumn(name = "Auth_id")
	    private Author author;

	    // Getters and setters

		public Book() {
		super();
	}

		public Book(Long booksid, String bookname, int pyear, int qnt, int price, Author author) {
		super();
		this.booksid = booksid;
		this.bookname = bookname;
		this.pyear = pyear;
		this.qnt = qnt;
		this.price = price;
		this.author = author;
	}
		public int getQnt() {
			return qnt;
		}

		public void setQnt(int qnt) {
			this.qnt = qnt;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}
		
		public Long getBooksid() {
			return booksid;
		}

		public void setBooksid(Long booksid) {
			this.booksid = booksid;
		}

		public String getBookname() {
			return bookname;
		}

		public void setBookname(String bookname) {
			this.bookname = bookname;
		}

		public int getPyear() {
			return pyear;
		}

		public void setPyear(int pyear) {
			this.pyear = pyear;
		}

		public Author getAuth() {
			return author;
		}

		public void setAuth(Author author) {
			this.author = author;
		}
	
	

		@Override
		public String toString() {
			return "Book [booksid=" + booksid + ", bookname=" + bookname + ", pyear=" + pyear + ", author=" + author
					+ "]";
		}

		
	}

