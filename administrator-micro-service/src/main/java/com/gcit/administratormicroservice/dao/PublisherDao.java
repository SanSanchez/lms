package com.gcit.administratormicroservice.dao;

import com.gcit.administratormicroservice.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublisherDao extends JpaRepository<Publisher, Long> {
    Optional<Publisher> findByPublisherId(Long id);

    void deleteByPublisherId(Long id);
}