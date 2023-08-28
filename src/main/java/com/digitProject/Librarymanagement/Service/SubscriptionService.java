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
import com.digitProject.LibrarymanagementDTO.BookDTO;
import com.digitProject.LibrarymanagementDTO.SubscriptionDTO;
import com.digitProject.LibrarymanagementDTO.UserDTO;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SubscriptionService {
	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Autowired
	private UserRepositery userRepository;
    @Autowired
    private UserService userservice;
    

	public SubscriptionDTO SubmapToDTO(Subscription subscription) {
		SubscriptionDTO dto = new SubscriptionDTO();
		dto.setId(subscription.getId());
		dto.setName(subscription.getName());
		dto.setDescription(subscription.getDescription());
		dto.setPrice(subscription.getPrice());
		return dto;
	}


	public Subscription SubmapToEntity(SubscriptionDTO dto) {
		Subscription subscription = new Subscription();
		subscription.setId(dto.getId());
		subscription.setName(dto.getName());
		subscription.setDescription(dto.getDescription());
		subscription.setPrice(dto.getPrice());
		return subscription;
	}
	
	public UserDTO UsermapToDTO(User user) {
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


	public List<SubscriptionDTO> getAllSubscriptions() {
	List<Subscription> subscriptions = subscriptionRepository.findAll();
	return subscriptions.stream().map(this::SubmapToDTO).collect(Collectors.toList());
	}

	public UserDTO subscribeToPlanService(Long userId, Long subscriptionId) {
	User user = userRepository.findById(userId)
	.orElseThrow(() -> new EntityNotFoundException("User not found"));

	if (user.getSubscription() != null) {
	throw new IllegalStateException("User is already subscribed to a plan");
	}

	Subscription subscription = subscriptionRepository.findById(subscriptionId)
	.orElseThrow(() -> new EntityNotFoundException("Subscription not found"));

	user.setSubscription(subscription);
	user = userRepository.save(user);

	return UsermapToDTO(user);
	}

	
	public UserDTO unsubscribeFromPlan(Long userId) {
	User user = userRepository.findById(userId)
	.orElseThrow(() -> new EntityNotFoundException("User not found"));

	if (user.getSubscription() == null) {
	throw new IllegalStateException("User is not subscribed to any plan");
	}

	user.setSubscription(null);
	user = userRepository.save(user);

	return UsermapToDTO(user);
	}

}
