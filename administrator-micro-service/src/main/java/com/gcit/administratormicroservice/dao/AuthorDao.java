package com.gcit.administratormicroservice.dao;

import com.gcit.administratormicroservice.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorDao extends JpaRepository<Author, Long> {
    Author findByAuthorName(String authorName);

    Optional<Author> findByAuthorId(Long id);

    void deleteByAuthorId(Long id);
}
