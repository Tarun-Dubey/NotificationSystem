package com.wavemaker.notification.dao;

import com.wavemaker.notification.entity.types.PushNotification;

import java.util.List;

/**
 * Created by tarund on 2/8/16.
 */
public interface PushNotificationDao {

    void addNotification(PushNotification pushNotification);
    List<PushNotification> listPendingNotifications();
    void processNotification(String id);
}
