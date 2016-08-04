package com.wavemaker.notification.manager;

import com.wavemaker.notification.entity.types.PushNotification;

import java.util.List;

/**
 * Created by tarund on 3/8/16.
 */
public interface PushNotificationManager {
    void addNotification(PushNotification pushNotification);
    List<PushNotification> listPendingNotifications();
    void processNotification(String id);
}
