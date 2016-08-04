package com.wavemaker.notification.service;

import com.wavemaker.notification.entity.Publisher;
import com.wavemaker.notification.entity.PublisherStub;

/**
 * Created by tarund on 2/8/16.
 */
public interface PublisherService {

    Publisher create(PublisherStub publisherStub);
    Publisher getPublisher(String name);
    int update(PublisherStub publisherStub);
    boolean isExists(String name);
    void remove(String name);
}
