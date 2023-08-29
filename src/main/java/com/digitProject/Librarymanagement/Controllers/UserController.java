package com.digitProject.Librarymanagement.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitProject.Librarymanagement.Entity.Book;
import com.digitProject.Librarymanagement.Entity.User;
import com.digitProject.Librarymanagement.Service.BookService;
import com.digitProject.Librarymanagement.Service.SubscriptionService;
import com.digitProject.Librarymanagement.Service.UserService;
import com.digitProject.LibrarymanagementDTO.BookDTO;
import com.digitProject.LibrarymanagementDTO.UserDTO;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
	private BookService bookService;
    @Autowired
    private SubscriptionService subscriptionService;
    
	//Fetching all the books from DB
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    //Creating User 
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }
    
    //User Taking Subscription
    @PostMapping("/{userId}/subscribe/{subscriptionId}")
    public ResponseEntity<String> subscribeToPlan(@PathVariable Long userId,@PathVariable Long subscriptionId) {

    UserDTO user = subscriptionService.subscribeToPlanService(userId, subscriptionId);

    return ResponseEntity.ok("User " + user.getName() + " subscribed to Plan");
    }
    
    //Unsubscribe
    @PostMapping("/{userId}/unsubscribe")
    public ResponseEntity<String> unsubscribeFromPlan(
    @PathVariable Long userId) {
    UserDTO user = subscriptionService.unsubscribeFromPlan(userId);
    return ResponseEntity.ok("User " + user.getName() + " unsubscribed from the plan");
    }
    
    //User Borrowing Book
    @PostMapping("/{bookId}/borrow/{userId}")
	public ResponseEntity<?> borrowBook(@PathVariable("bookId") Long bookId, @PathVariable("userId") Long userId) {
		ResponseEntity<?> borrowedBook = bookService.borrowBook(bookId, userId);
		return borrowedBook;
	
	}
    
    //User returning the Book
	@PostMapping("/{bookId}/return")
	public ResponseEntity<?> returnBook(@PathVariable Long bookId) {
		ResponseEntity<?> returnedBook = bookService.returnBook(bookId);
		return returnedBook;
	}
    
}
