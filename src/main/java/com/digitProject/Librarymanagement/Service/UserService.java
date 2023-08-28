package com.digitProject.Librarymanagement.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitProject.Librarymanagement.Entity.Book;
import com.digitProject.Librarymanagement.Entity.Subscription;
import com.digitProject.Librarymanagement.Entity.User;
import com.digitProject.Librarymanagement.Repositery.SubscriptionRepository;
import com.digitProject.Librarymanagement.Repositery.UserRepositery;
import com.digitProject.LibrarymanagementDTO.UserDTO;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepositery userRepository;

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Autowired
	private SubscriptionService subscriptionService;

	public UserDTO mapToDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setSubscription(user.getSubscription()); // Map subscription to DTO
		return dto;
	}

	public User mapToEntity(UserDTO dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setName(dto.getName());
		user.setSubscription(dto.getSubscription()); // Map subscription
											    	// to entity
		return user;
	}

	public List<User> findAll() {

		return userRepository.findAll();

	}

	public User save(User user) {

		return userRepository.save(user);

	}

	public User getBookById(Long id) {

		return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));

	}

}
