package com.gcit.librarianmicroservice.dao;

import com.gcit.librarianmicroservice.model.LibraryBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryBranchDao extends JpaRepository<LibraryBranch, Long> {

}