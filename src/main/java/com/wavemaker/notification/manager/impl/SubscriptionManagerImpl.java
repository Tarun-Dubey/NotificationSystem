package com.wavemaker.notification.manager.impl;

import com.wavemaker.notification.dao.SubscriptionDao;
import com.wavemaker.notification.entity.Subscription;
import com.wavemaker.notification.entity.SubscriptionStub;
import com.wavemaker.notification.entity.types.PushNotification;
import com.wavemaker.notification.exception.ManagerException;
import com.wavemaker.notification.manager.ChannelManager;
import com.wavemaker.notification.manager.SubscriptionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by tarund on 18/7/16.
 */
@Service
public class SubscriptionManagerImpl implements SubscriptionManager {

    @Autowired
    SubscriptionDao subscriptionDao;

    @Autowired
    ChannelManager channelManager;

    public  Subscription subscribe(SubscriptionStub subscriptionStub){
        if(channelManager.isExists(subscriptionStub.getChannel()))
            return _subscribe(subscriptionStub);
        throw new ManagerException("The channel \""+subscriptionStub.getChannel()+"\" does not Exists");
    }

    private Subscription _subscribe(SubscriptionStub subscriptionStub){
        Subscription subscription = new Subscription();
        subscription.setId(UUID.randomUUID().toString());
        subscription.setName(subscriptionStub.getName());
        subscription.setChannel(subscriptionStub.getChannel());
        subscription.setUrl(subscriptionStub.getUrl());
        subscription.setSubscribedAt(new Date());
        subscription.setLastNotifiedAt(new Date());
        return subscriptionDao.subscribe(subscription);

    }
    public Subscription getSubscription(String name){
        return subscriptionDao.getSubscription(name);
    }

    public int update(SubscriptionStub subscriptionStub){
        return subscriptionDao.update(subscriptionStub);
    }
    public void unsubscribe(String name){
        subscriptionDao.unsubscribe(name);
    }

    public boolean isExists(String name) {
        return subscriptionDao.isExists(name);
    }


    public List<Subscription> listSubsribersForChannel(String channel){
        return subscriptionDao.listSubsribersForChannel(channel);
    }


    public List<PushNotification> listPendingNotifications(String channel) {
        return subscriptionDao.listPendingNotifications(channel);
    }

   /* public int updateLastNotified(String channel,String url,Long notifiedAt){
        return subscriptionDao.updateLastNotified(channel,url,notifiedAt);
    }*/

}
