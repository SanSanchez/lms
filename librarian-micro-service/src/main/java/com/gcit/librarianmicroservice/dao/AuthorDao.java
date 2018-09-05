package com.gcit.librarianmicroservice.dao;

import com.gcit.librarianmicroservice.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<Author, Long> {
    Author findByAuthorName(String authorName);
}
