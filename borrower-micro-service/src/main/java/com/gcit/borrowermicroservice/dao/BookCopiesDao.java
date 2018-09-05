package com.gcit.borrowermicroservice.dao;

import com.gcit.borrowermicroservice.model.BookCopies;
import com.gcit.borrowermicroservice.model.BookCopiesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookCopiesDao extends JpaRepository<BookCopies, BookCopiesId> {
    @Query("Select bc From BookCopies bc where bc.cId.bookId = ?1 and bc.cId.branchId = ?2")
    BookCopies findByChargers(Long bookId, Long branchId);

    @Query("Select bc From BookCopies bc where bc.cId.branchId = ?1")
    List<BookCopies> findAllByBranchId(Long branchId);

}
