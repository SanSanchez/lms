package com.gcit.administratormicroservice.controller;

import com.gcit.administratormicroservice.dao.PublisherDao;
import com.gcit.administratormicroservice.exceptions.ResourceNotFoundException;
import com.gcit.administratormicroservice.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class AdminPublisherController {

    @Autowired
    private PublisherDao pDao;

    @RequestMapping("/publishers")
    @ResponseStatus(HttpStatus.OK)
    public List<Publisher> getAllPublishers() {
        return pDao.findAll();
    }

    @RequestMapping("/publishers/{publisherId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Publisher> getPublisher(@PathVariable Long publisherId) {
        return pDao.findByPublisherId(publisherId);
    }

    @RequestMapping(value = "/publisher", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher newPublisher(@Valid @RequestBody Publisher publisher) {
        return pDao.save(publisher);
    }

    @RequestMapping(value = "/publishers/{publisherId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable Long publisherId) {
        pDao.deleteByPublisherId(publisherId);
    }

    @RequestMapping(value = "/publishers/{publisherId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Publisher updatePublisher(@PathVariable Long publisherId,
                                   @RequestBody Publisher newPublisher) {
        Publisher publisher = pDao.findByPublisherId(publisherId).orElse(null);

        if (publisher != null) {
            newPublisher.setPublisherId(publisher.getPublisherId());
            return pDao.save(newPublisher);
        } else {
            throw new ResourceNotFoundException("This publisher cannot be found.");
        }
    }
}