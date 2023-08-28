package com.digitProject.Librarymanagement.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitProject.Librarymanagement.Entity.Book;
import com.digitProject.Librarymanagement.Service.BookService;
import com.digitProject.LibrarymanagementDTO.BookDTO;

@RestController
@RequestMapping("/api/books")
public class BookController {
	@Autowired
	private BookService bookService;
	
	//Creating Book in DB
	@PostMapping
	public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO book) {
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(book));
	}
   
	//Fetching all the books from DB
	@GetMapping
	public List<BookDTO> getAllBook() {
		return bookService.findAll();
	}
    


	//Fetching Book through Id
	@GetMapping("/{id}")
	public ResponseEntity<String> getBook(@PathVariable Long id) {
		return bookService.getBookById(id);
		
	}

	//Updating Book By Id
	@PutMapping("/{id}")
	public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO book) {
	BookDTO updatedBook = bookService.updateBook(id, book);
	return ResponseEntity.ok(updatedBook);
	}

	
	//Deleting Book by Id
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		bookService.deleteById(id);
	}

	
}
