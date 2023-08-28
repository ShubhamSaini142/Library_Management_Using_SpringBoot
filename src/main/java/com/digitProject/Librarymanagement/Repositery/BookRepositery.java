package com.digitProject.Librarymanagement.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.digitProject.Librarymanagement.Entity.Admin;
import com.digitProject.Librarymanagement.Entity.Book;
@Repository
public interface BookRepositery extends JpaRepository<Book, Long>{

}
