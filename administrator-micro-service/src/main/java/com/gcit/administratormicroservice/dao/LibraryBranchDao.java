package com.gcit.administratormicroservice.dao;

import com.gcit.administratormicroservice.model.LibraryBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryBranchDao  extends JpaRepository<LibraryBranch, Long> {
    Optional<LibraryBranch> findByBranchId(Long id);
    void deleteByBranchId(Long id);
}