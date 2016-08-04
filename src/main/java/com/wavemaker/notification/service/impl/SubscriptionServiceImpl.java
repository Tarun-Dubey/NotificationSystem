package com.wavemaker.notification.service.impl;

import com.wavemaker.notification.entity.Subscription;
import com.wavemaker.notification.entity.SubscriptionStub;
import com.wavemaker.notification.entity.types.PushNotification;
import com.wavemaker.notification.manager.SubscriptionManager;
import com.wavemaker.notification.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tarund on 18/7/16.
 */
@Service
public class SubscriptionServiceImpl  implements SubscriptionService{

    @Autowired
    private SubscriptionManager subscriptionManager;

    public Subscription subscribe(SubscriptionStub subscriptionStub){
        return subscriptionManager.subscribe(subscriptionStub);
    }


    public Subscription getSubscription(String name){
        return subscriptionManager.getSubscription(name);
    }

    public void unsubscribe(String name){
        subscriptionManager.unsubscribe(name);
    }

    public boolean isExists(String name) {
        return subscriptionManager.isExists(name);
    }

    public int update(SubscriptionStub subscriptionStub){
       return  subscriptionManager.update(subscriptionStub);
    }


    public  List<Subscription> listSubsribersForChannel(String channel){
        return subscriptionManager.listSubsribersForChannel(channel);
    }

    public List<PushNotification> listPendingNotifications(String channel) {
        return subscriptionManager.listPendingNotifications(channel);
    }

   /* public int updateLastNotified(String channel,String url,Long notifiedAt){
        return subscriptionManager.updateLastNotified(channel,url,notifiedAt);
    }*/

}
