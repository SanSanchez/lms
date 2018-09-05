package com.gcit.administratormicroservice.controller;

import com.gcit.administratormicroservice.dao.LibraryBranchDao;
import com.gcit.administratormicroservice.exceptions.ResourceNotFoundException;
import com.gcit.administratormicroservice.model.LibraryBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class AdminBranchController {

    @Autowired
    private LibraryBranchDao lDao;

    @RequestMapping("/branches")
    @ResponseStatus(HttpStatus.OK)
    public List<LibraryBranch> getAllLibraryBranches() {
        return lDao.findAll();
    }

    @RequestMapping("/branches/{branchId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<LibraryBranch> getLibraryBranch(@PathVariable Long branchId) {
        return lDao.findByBranchId(branchId);
    }

    @Transactional
    @RequestMapping(value = "/branch", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public LibraryBranch newLibraryBranch(@Valid @RequestBody LibraryBranch branch) {
        return lDao.save(branch);
    }

    @Transactional
    @RequestMapping(value = "/branches/{branchId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLibraryBranch(@PathVariable Long branchId) {
        lDao.deleteByBranchId(branchId);
    }

    @Transactional
    @RequestMapping(value = "/branches/{branchId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public LibraryBranch updateLibraryBranch(@PathVariable Long branchId,
                                   @RequestBody LibraryBranch newBranch) {
        LibraryBranch branch = lDao.findByBranchId(branchId).orElse(null);

        if (branch != null) {
            newBranch.setBranchId(branch.getBranchId());
            branch = newBranch;
        } else {
            throw new ResourceNotFoundException("That branch cannot be found at this time");
        }

        return lDao.save(branch);
    }
}