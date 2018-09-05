package com.gcit.borrowermicroservice.dao;

import com.gcit.borrowermicroservice.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<Author, Long> {
    Author findByAuthorName(String authorName);
}
