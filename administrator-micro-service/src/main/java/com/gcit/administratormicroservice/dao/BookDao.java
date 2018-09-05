package com.gcit.administratormicroservice.dao;

import com.gcit.administratormicroservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {
    Book findByTitle(String bookTitle);
    Optional<Book> findByBookId(Long id);
    void deleteByBookId(Long id);
}
