package Library_Management_System;

import javax.persistence.*;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Author {
	
  
    
   

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auth_id")
    private Long authId;

    @Column(name = "auth_name")
    private String authname;
    private String location;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books = new HashSet<>();
    
    public Author() {
		super();
	}

	public Author(Long authId, String authname, String location, Set<Book> books) {
		super();
		this.authId = authId;
		this.authname = authname;
		this.location = location;
		this.books = books;
	}

    // Getters and setters

   

	public Long getAuthId() {
		return authId;
	}

	public void setAuthId(Long authId) {
		this.authId = authId;
	}

	public String getAuthname() {
		return authname;
	}

	public void setAuthname(String authname) {
		this.authname = authname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

    // setUser method to associate a task with a user
    public void setUser(Book book) {
    	book.setAuth(this);
    	books.add(book);
    }

}