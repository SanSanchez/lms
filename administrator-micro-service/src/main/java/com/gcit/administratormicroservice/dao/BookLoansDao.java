package com.gcit.administratormicroservice.dao;

import com.gcit.administratormicroservice.model.BookLoans;
import com.gcit.administratormicroservice.model.BookLoansId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookLoansDao extends JpaRepository<BookLoans, BookLoansId> {
    List<BookLoans> findAllByLIdBranchId(Long branchId);

    @Query("Select bl From BookLoans bl where bl.lId.bookId = ?1 and bl.lId.branchId = ?2 and bl.lId.cardNo = ?3")
    Optional<BookLoans> findByCharger(Long bookId, Long branchId, Long cardNo);
}