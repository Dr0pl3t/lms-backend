package com.dr0pl3t.lms.repository;

import com.dr0pl3t.lms.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

//Implements JpaRepository operations (CRUD,...)
public interface BookRepository extends JpaRepository<Book, Long> {
}
