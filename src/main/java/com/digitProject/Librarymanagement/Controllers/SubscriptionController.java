package com.digitProject.Librarymanagement.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.digitProject.Librarymanagement.Entity.Book;
import com.digitProject.Librarymanagement.Entity.Subscription;
//import com.digitProject.Librarymanagement.Repositery.SubscriptionRepository;
import com.digitProject.Librarymanagement.Service.SubscriptionService;
import com.digitProject.LibrarymanagementDTO.SubscriptionDTO;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {


@Autowired
public SubscriptionService subcriptionService;

//Fetching Subscription Plan By Id
@GetMapping
public List<SubscriptionDTO> getAllSubs() {
	return subcriptionService.getAllSubscriptions();
}


}
