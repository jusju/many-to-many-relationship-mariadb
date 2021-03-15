package k2020.manytomany.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import k2020.manytomany.domain.Book;
import k2020.manytomany.domain.BookRepository;
import k2020.manytomany.domain.CategoryRepository;
import k2020.manytomany.domain.Reader;
import k2020.manytomany.domain.ReaderRepository;

@Controller
public class ManyToManyController {
	
	@Autowired	
	BookRepository bookRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ReaderRepository readerRepository;
	
	
    @GetMapping(value="readerLikes")
    public String readerLikes(Model model) {	
        model.addAttribute("readers", readerRepository.findAll());
        return "readerLikes";
    }
    
   
    
	@GetMapping("addNewBook")
	public String addNewBook(Model model) {
		model.addAttribute("newBook", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addNewBook";
		
	}
	
	@GetMapping("addNewReader")
	public String addNewReader(Model model) {
		model.addAttribute("newReader", new Reader());
		//model.addAttribute("categories", categoryRepository.findAll());
		return "addNewReader";
		
	}

	@PostMapping("saveBook")
	public String saveBook(Book book) {
		System.out.println("saveBook -metodi");
		System.out.println(book);
        bookRepository.save(book);
        return "redirect:booklist";
		
	}
	
    @GetMapping(value="/booklist")
    public String booklist(Model model) {	
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBookId(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("editBook", bookRepository.findById(bookId).get());
		model.addAttribute("categories", categoryRepository.findAll());
        return "editBook";
		
	}


}
