package com.gcit.librarianmicroservice.controller;

import com.gcit.librarianmicroservice.dao.BookCopiesDao;
import com.gcit.librarianmicroservice.dao.LibraryBranchDao;
import com.gcit.librarianmicroservice.exceptions.ResourceNotFoundException;
import com.gcit.librarianmicroservice.model.BookCopies;
import com.gcit.librarianmicroservice.model.LibraryBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping
public class LibrarianController {

    @Autowired
    private LibraryBranchDao lDao;

    @Autowired
    private BookCopiesDao cDao;

    @RequestMapping("/branches")
    @ResponseStatus(HttpStatus.OK)
    public List<LibraryBranch> getBranches() {
        return lDao.findAll();
    }

    @RequestMapping("/branches/{branchId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Optional<LibraryBranch> getBranch(@PathVariable Long branchId) {
        return lDao.findById(branchId);
    }

    @RequestMapping("/branches/{branchId}/copies")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<BookCopies> getCopies(@PathVariable Long branchId) { return cDao.findAllByBranchId(branchId); }

    @Transactional
    @RequestMapping(value = "/branches/{branchId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public LibraryBranch updateBranch(@PathVariable Long branchId,
                                      @RequestBody LibraryBranch newBranch) {
        LibraryBranch branch = lDao.findById(branchId).orElse(null);

        if (branch != null) {
            newBranch.setBranchId(branchId);
            return lDao.save(newBranch);
        } else {
            throw new ResourceNotFoundException("That branch cannot be found.");
        }
    }

    @RequestMapping("/branches/{branchId}/copies/{bookId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookCopies getBookCopies(@PathVariable Long branchId,
                                    @PathVariable Long bookId) {
        return cDao.findByChargers(bookId, branchId);
    }

    @Transactional
    @RequestMapping(value = "/branches/{branchId}/copies/{bookId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookCopies updateBookCopies(@PathVariable Long branchId,
                                       @PathVariable Long bookId,
                                       @RequestBody BookCopies newCopies) {
        BookCopies bc = cDao.findByChargers(bookId, branchId);

        if (bc.getBkcpyId() != null) {
            bc.setNoOfCopies(newCopies.getNoOfCopies());
        }

        return cDao.save(bc);
    }
}