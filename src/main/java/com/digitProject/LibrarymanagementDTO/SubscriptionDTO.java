package com.digitProject.LibrarymanagementDTO;

import java.util.ArrayList;
import java.util.List;

import com.digitProject.Librarymanagement.Entity.User;

public class SubscriptionDTO {
	private Long id;

	private String name;
	private String Description;
	private double price;
	private List<User> users = new ArrayList<User>();
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
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	

}
