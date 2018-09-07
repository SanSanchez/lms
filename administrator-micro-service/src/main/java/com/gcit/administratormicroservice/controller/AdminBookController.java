package com.gcit.administratormicroservice.controller;

import com.gcit.administratormicroservice.dao.BookDao;
import com.gcit.administratormicroservice.exceptions.ResourceNotFoundException;
import com.gcit.administratormicroservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping
public class AdminBookController {

    @Autowired
    private BookDao bDao;

    @RequestMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {
        return bDao.findAll();
    }

    @RequestMapping("/books/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Book> getBook(@PathVariable Long bookId) {
        return bDao.findByBookId(bookId);
    }

    @Transactional
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Book newBook(@Valid @RequestBody Book book) {
        return bDao.save(book);
    }

    @Transactional
    @RequestMapping(value = "/books/{bookId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long bookId) {
        bDao.deleteByBookId(bookId);
    }

    @Transactional
    @RequestMapping(value = "/books/{bookId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Book updateBook(@PathVariable Long bookId,
                           @RequestBody Book newBook) {
        Book book = bDao.findByBookId(bookId).orElse(null);

        if (book != null) {
            newBook.setBookId(book.getBookId());
            return bDao.save(newBook);
        } else {
            throw new ResourceNotFoundException("This book cannot be found.");
        }
    }
}
