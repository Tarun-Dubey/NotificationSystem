package com.wavemaker.notification.service.impl;

import com.wavemaker.notification.entity.Notification;
import com.wavemaker.notification.entity.NotificationStub;
import com.wavemaker.notification.manager.NotificationManager;
import com.wavemaker.notification.service.NotificationService;
import com.wavemaker.notification.service.SubscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tarund on 29/6/16.
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);

    @Autowired
    private NotificationManager notificationManager;
    @Autowired
    private SubscriptionService subscriptionService;

    public void addNotification(NotificationStub notificationStub){
            notificationManager.addNotification(notificationStub);
    }


    public List<Notification> listNotification(String userId){

        return notificationManager.listNotification(userId);
    }

    public int getUnReadNotificationsCountForUser(String userId){
        logger.info("info-getUnReadNotificationsCountForUser request {}", userId);
        return notificationManager.getUnReadNotificationsCountForUser(userId);
    }
    public void processNotification(String notificationId){
         notificationManager.processNotification(notificationId);
    }

    public int deleteNotification(String id){
        return notificationManager.deleteNotification(id);
    }

    /*public String takeActionOnNotification(String action,Notification notification){
        return notificationManager.takeActionOnNotification(action,notification);
    }

    public void updateNotification(Notification notification){

        notificationManager.updateNotification(notification);
    }
    public List<Notification> listNotifications(Long lastNotifiedAt){
        return notificationManager.listNotifications(lastNotifiedAt);
    }*/
}
