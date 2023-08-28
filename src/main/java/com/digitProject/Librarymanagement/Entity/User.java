package com.digitProject.Librarymanagement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class User {
	
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
		@ManyToOne
		@JoinColumn(name = "subscription_id")
		private Subscription subscription;
		
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
		public Subscription getSubscription() {
			return subscription;
		}
		public void setSubscription(Subscription subscription) {
			this.subscription = subscription;
		}
		
	    

	

}
