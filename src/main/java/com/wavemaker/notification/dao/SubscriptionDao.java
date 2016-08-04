package com.wavemaker.notification.dao;

import com.wavemaker.notification.entity.Subscription;
import com.wavemaker.notification.entity.types.PushNotification;
import com.wavemaker.notification.entity.SubscriptionStub;

import java.util.List;

/**
 * Created by tarund on 18/7/16.
 */
public interface SubscriptionDao {

    Subscription subscribe(Subscription subscription);
    Subscription getSubscription(String name);
    int update(SubscriptionStub subscriptionStub);
    boolean isExists(String name);
    void unsubscribe(String name);

    List<Subscription> listSubsribersForChannel(String channel);

    List<PushNotification> listPendingNotifications(String channel);

    //int updateLastNotified(String channel,String url,Long notifiedAt);
}
