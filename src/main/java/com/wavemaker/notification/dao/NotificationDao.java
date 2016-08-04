package com.wavemaker.notification.dao;

import com.wavemaker.notification.entity.Notification;

import java.util.List;

/**
 * Created by tarund on 29/6/16.
 */
public interface NotificationDao {

    void addNotification(Notification notification);
    List<Notification> listNotification(String userId);
    int getUnReadNotificationsCountForUser(String userId);
    void processNotification(String notificationId);
    int deleteNotification(String id);

   /* void publish(PushNotification notification, String channel);
    void updateNotification(String action,String notificationId);
    void updateNotification(Notification notification);
    List<Notification> listNotifications(Long lastNotifiedAt);
    List<Subscription> listSubscribers(String channel);
    List<PushNotification> listPendingNotifications(String channel);*/
}
