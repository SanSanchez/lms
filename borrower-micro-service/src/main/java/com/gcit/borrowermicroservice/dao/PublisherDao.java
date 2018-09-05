package com.gcit.borrowermicroservice.dao;

import com.gcit.borrowermicroservice.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherDao extends JpaRepository<Publisher, Long> {
    Publisher findByPublisherName(String publisherName);
}