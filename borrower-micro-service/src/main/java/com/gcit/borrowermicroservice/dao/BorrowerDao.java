package com.gcit.borrowermicroservice.dao;

import com.gcit.borrowermicroservice.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerDao extends JpaRepository<Borrower, Long> {

}
