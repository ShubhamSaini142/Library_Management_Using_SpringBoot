package com.digitProject.Librarymanagement.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.digitProject.Librarymanagement.Entity.Book;
import com.digitProject.Librarymanagement.Entity.User;
//import com.digitProject.Librarymanagement.Mapper.BookMapper;
import com.digitProject.Librarymanagement.Repositery.BookRepositery;
import com.digitProject.Librarymanagement.Repositery.UserRepositery;
import com.digitProject.LibrarymanagementDTO.BookDTO;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookService {
	@Autowired
	private BookRepositery bookRepository;
	@Autowired
	private UserRepositery userRepository;

	private BookDTO mapToDTO(Book book) {
		BookDTO dto = new BookDTO();
		dto.setId(book.getId());
		dto.setTitle(book.getTitle());
		dto.setAuthor(book.getAuthor());
		dto.setBorrowed(book.isBorrowed());
		dto.setBorrowedBy(book.getBorrowedBy());
		return dto;
	}

	private Book mapToEntity(BookDTO bookDTO) {
		Book book = new Book();
		book.setId(bookDTO.getId());
		book.setTitle(bookDTO.getTitle());
		book.setAuthor(bookDTO.getAuthor());
		book.setBorrowed(bookDTO.isBorrowed());
		book.setBorrowedBy(bookDTO.getBorrowedBy());
		return book;
	}

	public List<BookDTO> findAll() {
		List<Book> books = bookRepository.findAll();
		return books.stream().map(this::mapToDTO).collect(Collectors.toList());

	}

	public ResponseEntity<?> getBookById(Long id) {
		Book book = bookRepository.findById(id).orElse(null);
		if (book == null) {
			return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	public BookDTO saveBook(BookDTO bookDTO) {
		Book book = mapToEntity(bookDTO);
		book = bookRepository.save(book);
		return mapToDTO(book);
	}

	public void deleteById(Long id) {
		bookRepository.deleteById(id);
	}

	public ResponseEntity<?> borrowBook(Long bookId, Long userId) {
		Book book = bookRepository.findById(bookId).orElse(null);
		User user = userRepository.findById(userId).orElse(null);
		if (book != null && !book.isBorrowed() && user != null) {
			book.setBorrowedBy(user);
			book.setBorrowed(true);
			book = bookRepository.save(book);
//			return mapToDTO(book);
			return new ResponseEntity<>(book, HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Book Not Found", HttpStatus.NOT_FOUND);

		}

	}

	public ResponseEntity<?> returnBook(Long bookId) {
		Book book = bookRepository.findById(bookId).orElse(null);
		if (book != null && book.isBorrowed()) {
			book.setBorrowedBy(null);
			book.setBorrowed(false);
			book = bookRepository.save(book);
			return new ResponseEntity<>(book, HttpStatus.OK);
		}
		return new ResponseEntity<>("Book Not Found", HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<?> updateBook(Long id, BookDTO updatedBookDTO) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			Book existingBook = optionalBook.get();
			existingBook.setTitle(updatedBookDTO.getTitle());
			existingBook.setAuthor(updatedBookDTO.getAuthor());
			bookRepository.save(existingBook);
			return new ResponseEntity<>(existingBook, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("BOOK NOT FOUND", HttpStatus.NOT_FOUND);
		}
	}

}
