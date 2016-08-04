package com.wavemaker.notification.manager.impl;

import com.wavemaker.notification.dao.NotificationDao;
import com.wavemaker.notification.entity.Notification;
import com.wavemaker.notification.entity.NotificationStub;
import com.wavemaker.notification.entity.Subscription;
import com.wavemaker.notification.entity.User;
import com.wavemaker.notification.entity.types.NotificationStatus;
import com.wavemaker.notification.entity.types.PushNotification;
import com.wavemaker.notification.manager.ChannelManager;
import com.wavemaker.notification.manager.NotificationManager;
import com.wavemaker.notification.manager.PushNotificationManager;
import com.wavemaker.notification.manager.SubscriptionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * Created by tarund on 29/6/16.
 */
@Service
public class NotificationManagerImpl implements NotificationManager {

    @Autowired
    private NotificationDao notificationDao;

    @Autowired
    private PushNotificationManager pushNotificationManager;

    @Autowired
    private ChannelManager channelManager;

    @Autowired
    private SubscriptionManager subscriptionManager;

    public void addNotification(NotificationStub notificationStub){
        if(notificationStub.isPushNotification())
            _addPushNotification(notificationStub);
        _addPullNotification(notificationStub);

    }

    private void _addPushNotification(NotificationStub notificationStub){
        List<String> channelsList = new LinkedList<String>();
        List<Subscription> subscribersList = new LinkedList<Subscription>();
        channelsList = notificationStub.getChannelIds();
        for(String channel : channelsList){
            if(channelManager.isExists(channel)){
                subscribersList = subscriptionManager.listSubsribersForChannel(channel);
                for(Subscription subscription : subscribersList){
                    PushNotification pushNotification = new PushNotification();
                    pushNotification.setId(UUID.randomUUID().toString());
                    pushNotification.setPayload(notificationStub);
                    pushNotification.setSubscriberId(subscription.getId());
                    pushNotification.setSubscriberUrl(subscription.getUrl());
                    pushNotification.setNotificationStatus(NotificationStatus.PENDING);
                    pushNotification.setRetries(0);
                    pushNotification.setChannel(channel);
                    pushNotification.setCreatedAt(new Date());
                    pushNotification.setLastModifiedAt(new Date());
                    pushNotification.setDeleted(Boolean.FALSE);
                    pushNotificationManager.addNotification(pushNotification);
                }
                subscribersList.clear();
            }
        }


    }
    private void _addPullNotification(NotificationStub notificationStub){
        for(User receiver : notificationStub.getReceivers()){
            Notification notification = new Notification();
            notification.setId(UUID.randomUUID().toString());
            notification.setReceiver(receiver);
            notification.setMessageTemplate(notificationStub.getMessageTemplate());
            notification.setArguments(notificationStub.getArguments());
            notification.setActions(notificationStub.getActions());
            notification.setNotifyType(notificationStub.getNotifyType());
            notification.setNotificationStatus(NotificationStatus.PENDING);
            notification.setCreatedAt(new Date());
            notification.setLastModifiedAt(new Date());
            notification.setDeleted(Boolean.FALSE);
            notificationDao.addNotification(notification);
        }
    }
    public List<Notification> listNotification(String userId){
        return notificationDao.listNotification(userId);
    }

    public int getUnReadNotificationsCountForUser(String userId){
        return notificationDao.getUnReadNotificationsCountForUser(userId);
    }


    public void processNotification(String notificationId){
         notificationDao.processNotification(notificationId);
    }

    public int deleteNotification(String id){
        return notificationDao.deleteNotification(id);
    }



   /* public String takeActionOnNotification(String action,Notification notification){
        notificationDao.updateNotification(action,notification.getNotificationId());
        Notification newNotification= new Notification();
        newNotification.setNotificationId(UUID.randomUUID().toString());
        newNotification.setActor(notification.getRecipient());
        newNotification.setProject(notification.getProject());
        newNotification.setTeam(notification.getTeam());
        newNotification.setRecipient(notification.getActor());
        newNotification.setAction(action);
        newNotification.setNotificationType("Read");
        newNotification.setNotificationStatus("Unread");
        notificationDao.addNotification(newNotification);
        return action;
    }
    */

   /* public List<PushNotification> listPendingNotifications(String channel){
        return notificationDao.listPendingNotifications(channel);
    }

    public void updateNotification(Notification notification){

        notificationDao.updateNotification(notification);
    }
    public List<Notification> listNotifications(Long lastNotifiedAt){
       return notificationDao.listNotifications(lastNotifiedAt);
    }*/
}
