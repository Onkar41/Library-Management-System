package Library_Management_System;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "IssuedBooks")
public class IssuedBooks {
	    public IssuedBooks() {
		super();
	}



		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "Ibook_id")
	    private Long bookid;

	    @Column(name = "book_name")
	    private String bookname;
	  

	    
	    @ManyToOne
	    @JoinColumn(name = "I_Id")
	    private IssueBookTo to;



		public Long getBookid() {
			return bookid;
		}



		public void setBookid(Long bookid) {
			this.bookid = bookid;
		}



		public String getBookname() {
			return bookname;
		}



		public void setBookname(String bookname) {
			this.bookname = bookname;
		}



		public IssueBookTo getTo() {
			return to;
		}



		public void setTo(IssueBookTo to) {
			this.to = to;
		}
		


}
