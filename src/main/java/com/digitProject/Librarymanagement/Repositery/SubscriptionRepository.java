package com.digitProject.Librarymanagement.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitProject.Librarymanagement.Entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{

}
