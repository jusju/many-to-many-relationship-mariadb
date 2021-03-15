package k2020.manytomany;

import java.util.Collection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k2020.manytomany.domain.Book;
import k2020.manytomany.domain.BookRepository;
import k2020.manytomany.domain.Reader;
import k2020.manytomany.domain.ReaderRepository;

@SpringBootApplication
public class ManyToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, 
			ReaderRepository readerRepository) {
		return (args) -> {
				
			System.out.println("fetch all books");
			for (Book book : bookRepository.findAll()) {
				System.out.println(book.toString());
			}
			
			System.out.println("fetch all readers with book information");
			for (Reader reader : readerRepository.findAll()) {
				System.out.println("Lukijan nimi " + reader.getName());
				Collection <Book> lempikirjat = reader.getLikedBooks();
				System.out.println("lempikirjojen lukumäärä " + lempikirjat.size());
				for ( Book lempikirja : lempikirjat) {
					System.out.println("Kirjan nimi " + lempikirja.getTitle());
				}
			}
			
			System.out.println("fetch all books with reader information");
			for (Book book : bookRepository.findAll()) {
				System.out.println("Kirjan nimi " + book.getTitle());
				Collection <Reader> lukijat = book.getReaders();
				System.out.println("lukijoiden lukumäärä " + lukijat.size());
				for ( Reader lukija : lukijat) {
					System.out.println("Lukijan nimi " + lukija.getName());
				}
			}	        
		};
	}

}
