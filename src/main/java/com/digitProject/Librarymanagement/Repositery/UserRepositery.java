package com.digitProject.Librarymanagement.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitProject.Librarymanagement.Entity.User;
@Repository
public interface UserRepositery extends JpaRepository<User, Long> {
}