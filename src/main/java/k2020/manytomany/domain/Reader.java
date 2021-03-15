package k2020.manytomany.domain;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "reader")
public class Reader {
	
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; 
	private String name;
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//	@JoinTable(
//			name = "reader_likes", 
//			joinColumns = @JoinColumn(name = "reader_id"), 
//			inverseJoinColumns = @JoinColumn(name = "book_id"))
//	private List<Book> likedBooks;

	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "reader_likes",
            joinColumns = {
                    @JoinColumn(name = "reader_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "book_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Collection<Book> likedBooks;
	
	public Reader() {
		super();
	}

	public Reader(String name) {
		super();
		this.name = name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	public Collection<Book> getLikedBooks() {
		return likedBooks;
	}

	public void setLikedBooks(Collection<Book> likedBooks) {
		this.likedBooks = likedBooks;
	}

	
	



}
