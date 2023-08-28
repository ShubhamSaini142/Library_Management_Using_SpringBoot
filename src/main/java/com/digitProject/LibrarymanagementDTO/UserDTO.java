package com.digitProject.LibrarymanagementDTO;

import com.digitProject.Librarymanagement.Entity.Subscription;

public class UserDTO {
	
	  private Long id;
	    private String name;
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
