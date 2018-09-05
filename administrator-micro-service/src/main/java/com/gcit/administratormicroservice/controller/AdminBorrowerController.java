package com.gcit.administratormicroservice.controller;

import com.gcit.administratormicroservice.dao.BorrowerDao;
import com.gcit.administratormicroservice.exceptions.ResourceNotFoundException;
import com.gcit.administratormicroservice.model.Borrower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class AdminBorrowerController {

    @Autowired
    private BorrowerDao bDao;

    @RequestMapping("/borrowers")
    @ResponseStatus(HttpStatus.OK)
    public List<Borrower> getAllBorrowers() {
        return bDao.findAll();
    }

    @RequestMapping("/borrowers/{borrowerId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Borrower> getBorrower(@PathVariable Long borrowerId) {
        return bDao.findByCardNo(borrowerId);
    }

    @RequestMapping(value = "/borrower", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Borrower newBorrower(@RequestBody Borrower borrower) {
        return bDao.save(borrower);
    }

    @RequestMapping(value = "/borrowers/{borrowerId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBorrower(@PathVariable Long borrowerId) {
        bDao.deleteByCardNo(borrowerId);
    }

    @RequestMapping(value = "/borrowers/{borrowerId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Borrower updateBorrower(@PathVariable Long borrowerId,
                               @RequestBody Borrower newBorrower) {
        Borrower borrower = bDao.findByCardNo(borrowerId).orElse(null);

        if (borrower != null) {
            newBorrower.setCardNo(borrower.getCardNo());
            borrower = newBorrower;
        } else {
            throw new ResourceNotFoundException("That borrower cannot be found.");
        }

        return bDao.save(borrower);
    }
}
