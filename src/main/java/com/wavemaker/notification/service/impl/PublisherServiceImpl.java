package com.wavemaker.notification.service.impl;

import com.wavemaker.notification.entity.Publisher;
import com.wavemaker.notification.entity.PublisherStub;
import com.wavemaker.notification.manager.PublisherManager;
import com.wavemaker.notification.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tarund on 2/8/16.
 */
@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    PublisherManager publisherManager;
    public Publisher create(PublisherStub publisherStub) {
        return publisherManager.create(publisherStub);
    }

    public Publisher getPublisher(String name) {
        return publisherManager.getPublisher(name);
    }

    public int update(PublisherStub publisherStub) {
        return publisherManager.update( publisherStub);
    }

    public boolean isExists(String name) {
        return publisherManager.isExists(name);
    }

    public void remove(String name) {
        publisherManager.remove(name);
    }
}
