package com.wavemaker.notification.manager.impl;

import com.wavemaker.notification.dao.PublisherDao;
import com.wavemaker.notification.entity.Publisher;
import com.wavemaker.notification.entity.PublisherStub;
import com.wavemaker.notification.exception.ManagerException;
import com.wavemaker.notification.manager.ChannelManager;
import com.wavemaker.notification.manager.PublisherManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by tarund on 2/8/16.
 */
@Service
public class PublisherManagerImpl implements PublisherManager{

    @Autowired
    PublisherDao publisherDao;

    @Autowired
    ChannelManager channelManager;

    public Publisher create(PublisherStub publisherStub) {
        if(channelManager.isExists(publisherStub.getChannel()))
            return _create(publisherStub);
        throw new ManagerException("The Channek \""+publisherStub.getChannel()+"\" does not exists");
    }

    private  Publisher _create(PublisherStub publisherStub){
        Publisher publisher = new Publisher();
        publisher.setId(UUID.randomUUID().toString());
        publisher.setName(publisherStub.getName());
        publisher.setKey(publisherStub.getKey());
        publisher.setChannel(publisherStub.getChannel());
        publisher.setRegisteredAt(new Date());
        return publisherDao.create(publisher);

    }
    public Publisher getPublisher(String name) {
        return publisherDao.getPublisher(name);
    }

    public int update(PublisherStub publisherStub) {
        return publisherDao.update(publisherStub);
    }

    public boolean isExists(String name) {
        return publisherDao.isExists(name);
    }

    public void remove(String name) {
        publisherDao.remove(name);
    }
}
