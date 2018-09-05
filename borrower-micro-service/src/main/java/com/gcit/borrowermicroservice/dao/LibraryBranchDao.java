package com.gcit.borrowermicroservice.dao;

import com.gcit.borrowermicroservice.model.LibraryBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryBranchDao  extends JpaRepository<LibraryBranch, Long> {

}