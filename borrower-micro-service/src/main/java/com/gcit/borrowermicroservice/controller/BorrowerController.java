package com.gcit.borrowermicroservice.controller;

import com.gcit.borrowermicroservice.dao.*;
import com.gcit.borrowermicroservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class BorrowerController {

    @Autowired
    private BorrowerDao bDao;

    @Autowired
    private BookLoansDao blDao;

    @Autowired
    private BookCopiesDao cDao;

    @Autowired
    private BookDao kDao;

    @Autowired
    private LibraryBranchDao lDao;

    @RequestMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Borrower> getBorrowers() {
        return bDao.findAll();
    }

    @RequestMapping(value = "/loans/{cardNo}")
    @ResponseStatus(HttpStatus.OK)
    public List<BookLoans> getLoans(@PathVariable Long cardNo) {
        Optional<Borrower> borrower = bDao.findById(cardNo);
        if (borrower.isPresent()) {
            return borrower.orElse(null).getLoans();
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/loans/{cardNo}/branches/{branchId}")
    @ResponseStatus(HttpStatus.OK)
    public List<BookLoans> getLoansAtBranch(@PathVariable Long cardNo,
                                            @PathVariable Long branchId ) {
        return blDao.findAllByLIdBranchId(branchId);
    }

    @RequestMapping("/loans/{cardNo}/branches/{branchId}/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooksAtBranch(@PathVariable Long cardNo,
                                          @PathVariable Long branchId) {
        List<BookCopies> bookCopies = cDao.findAllByBranchId(branchId);
        List<Book> books = new ArrayList<>();

        bookCopies.forEach(x -> books.add(x.getBook()));

        return books;
    }

    // FIXME
    @RequestMapping(value = "/loans/{cardNo}/branches/{branchId}/books",
            method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public BookLoans makeLoan(@PathVariable Long cardNo,
                              @PathVariable Long branchId,
                              @RequestBody String bookTitle) {
        Book book = kDao.findByTitle(bookTitle);
        BookCopies bc = cDao.findByChargers(book.getBookId(), branchId);
        BookLoansId blI = new BookLoansId(book.getBookId(), branchId, cardNo);

        bc.setNoOfCopies(bc.getNoOfCopies() -1);
        BookLoans bl = new BookLoans();
        bl.setLoanId(blI);
        bl.setBook(book);
        bl.setBorrower(bDao.getOne(cardNo));
        bl.setBranch(lDao.getOne(branchId));
        bl.setDateOut("2018-03-10 06:49:53.0");
        bl.setDueDate("2018-03-17 06:49:53.0");

        cDao.save(bc);
        return blDao.save(bl);
    }

    @RequestMapping(value = "/loans/{cardNo}/branches/{branchId}/books/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public BookLoans getLoan(@PathVariable Long cardNo,
                             @PathVariable Long branchId,
                             @PathVariable Long bookId) {
        return blDao.findByCharger(bookId, branchId, cardNo).orElse(null);
    }

    // Delete Loan
    // Update Copies.
    @RequestMapping(value = "/loans/{cardNo}/branches/{branchId}/books/{bookId}",
            method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLoan(@PathVariable Long cardNo,
                                @PathVariable Long branchId,
                                @PathVariable Long bookId) {
        Optional<BookLoans> a = blDao.findByCharger(bookId, branchId, cardNo);
        BookCopies b = cDao.findByChargers(bookId, branchId);

        try {
            b.setNoOfCopies(b.getNoOfCopies() + 1);
            cDao.save(b);
            blDao.delete(a.orElse(null));
        } catch (NullPointerException e) {
            System.out.println();
        }
    }
}