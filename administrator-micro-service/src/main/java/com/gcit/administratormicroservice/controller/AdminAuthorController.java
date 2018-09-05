package com.gcit.administratormicroservice.controller;

import com.gcit.administratormicroservice.dao.AuthorDao;
import com.gcit.administratormicroservice.exceptions.ResourceNotFoundException;
import com.gcit.administratormicroservice.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Transactional
@RestController
@RequestMapping
public class AdminAuthorController {

    @Autowired
    private AuthorDao aDao;

    @RequestMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public List<Author> getAllAuthors() {
        return aDao.findAll();
    }

    @RequestMapping("/authors/{authorId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Author> getAuthor(@PathVariable Long authorId) {
        return aDao.findByAuthorId(authorId);
    }

    @RequestMapping(value= "/author", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Author newAuthor(@Valid @RequestBody Author author) {
        return aDao.save(author);
    }

    @RequestMapping(value = "/authors/{authorId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable Long authorId) {
        aDao.deleteByAuthorId(authorId);
    }

    @RequestMapping(value = "/authors/{authorId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Author updateAuthor(@PathVariable Long authorId,
                           @RequestBody Author newAuthor) {
        Author author = aDao.findByAuthorId(authorId).orElse(null);

        if (author != null) {
            newAuthor.setAuthorId(author.getAuthorId());
            return aDao.save(newAuthor);
        } else {
            throw new ResourceNotFoundException("That author cannot be found.");
        }
    }
}
