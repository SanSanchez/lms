package com.gcit.borrowermicroservice.dao;

import com.gcit.borrowermicroservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {
    Book findByTitle(String bookTitle);

}
