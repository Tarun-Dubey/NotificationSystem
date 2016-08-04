package com.wavemaker.notification.manager;

import com.wavemaker.notification.entity.Subscription;
import com.wavemaker.notification.entity.SubscriptionStub;
import com.wavemaker.notification.entity.types.PushNotification;

import java.util.List;

/**
 * Created by tarund on 18/7/16.
 */
public interface SubscriptionManager {

    Subscription subscribe( SubscriptionStub subscriptionStub);
    Subscription getSubscription(String name);
    int update(SubscriptionStub subscriptionStub);
    void unsubscribe(String name);
    boolean isExists(String name);

    List<Subscription> listSubsribersForChannel(String channel);


    List<PushNotification> listPendingNotifications(String channel);

    //int updateLastNotified(String channel,String url,Long notifiedAt);
}
