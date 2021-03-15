package k2020.manytomany.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title, author, isbn;
	private int year;
	private double price;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryid")
	Category category;

	@ManyToMany(mappedBy = "likedBooks", fetch = FetchType.EAGER)
    private Set<Reader> readers;


	public Book() {
		super();
	}

	public Book(String title, String author, String isbn, int year, double price) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
		this.price = price;
	}

	public Book(String title, String author, int year) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;

	}

	public Book(String title, String author, int year, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.category = category;
	}

	public Book(String title, String author, int year, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.price = price;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	public Set<Reader> getReaders() {
		return readers;
	}

	public void setReaders(Set<Reader> readers) {
		this.readers = readers;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}

}
