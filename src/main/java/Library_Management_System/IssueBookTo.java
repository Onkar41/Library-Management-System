package Library_Management_System;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "IssueBookTo")
public class IssueBookTo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	    
    private Long I_Id;

    @Column(name = "Name")
    private String Name;
    private String phoneNo;
    private String Address;
    private String idate;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "to", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IssuedBooks> books = new HashSet<>();
    
	   

		public Long getI_Id() {
			return I_Id;
		}

		public String getIdate() {
			return idate;
		}

		public void setIdate(String idate) {
			this.idate = idate;
		}

		public void setI_Id(Long i_Id) {
			I_Id = i_Id;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public String getPhoneNo() {
			return phoneNo;
		}

		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}

		public String getAddress() {
			return Address;
		}

		public void setAddress(String address) {
			Address = address;
		}

		public Set<IssuedBooks> getBooks() {
			return books;
		}

		public void setBooks(Set<IssuedBooks> books) {
			this.books = books;
		}
		
		public void setUseres(IssuedBooks book) {
	    	book.setTo(this);
	    	books.add(book);
	    }
}
