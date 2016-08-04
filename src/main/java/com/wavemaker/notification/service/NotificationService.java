package com.wavemaker.notification.service;

import com.wavemaker.notification.entity.Notification;
import com.wavemaker.notification.entity.NotificationStub;

import java.util.List;

/**
 * Created by tarund on 29/6/16.
 */
public interface NotificationService {

    void addNotification(NotificationStub notificationStub);
    List<Notification> listNotification(String userId);
    int getUnReadNotificationsCountForUser(String userId);
    void processNotification(String notificationId);
    int deleteNotification(String id);

   /* String takeActionOnNotification(String action,Notification notification);
    void publish(NotificationStub notificationStub);
    void updateNotification(Notification notification);
    List<Notification> listNotifications(Long lastNotifiedAt);
    List<Subscription> listSubscribers(String channel);*/
 }
