package com.gcit.administratormicroservice.dao;

import com.gcit.administratormicroservice.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowerDao extends JpaRepository<Borrower, Long> {
    void deleteByCardNo(Long cardNo);
    Optional<Borrower> findByCardNo(Long cardNo);
}
