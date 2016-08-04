package com.wavemaker.notification.controller;

import com.wavemaker.notification.entity.Publisher;
import com.wavemaker.notification.entity.PublisherStub;
import com.wavemaker.notification.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tarund on 2/8/16.
 */
@RestController
@RequestMapping("publishers")
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody PublisherStub publisherStub){
        Publisher publisher= publisherService.create(publisherStub);

        return new ResponseEntity<Object>(publisher,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Publisher getPublisher(@PathVariable String name){
        return publisherService.getPublisher(name);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public boolean isExists(@RequestParam("name") String name){
        return publisherService.isExists(name);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public int getPublisher(@RequestBody PublisherStub publisherStub){
        return publisherService.update(publisherStub);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    public void remove(@PathVariable String name){
         publisherService.remove(name);
    }

}
