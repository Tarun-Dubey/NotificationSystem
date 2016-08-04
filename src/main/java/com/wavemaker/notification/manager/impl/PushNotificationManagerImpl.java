package com.wavemaker.notification.manager.impl;

import com.wavemaker.notification.dao.PushNotificationDao;
import com.wavemaker.notification.entity.types.PushNotification;
import com.wavemaker.notification.manager.PushNotificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tarund on 3/8/16.
 */
@Service
public class PushNotificationManagerImpl implements PushNotificationManager {

    @Autowired
    PushNotificationDao pushNotificationDao;

    public void addNotification(PushNotification pushNotification) {
        pushNotificationDao.addNotification(pushNotification);
    }

    public List<PushNotification> listPendingNotifications(){
        return pushNotificationDao.listPendingNotifications();
    }

    public void processNotification(String id) {
        pushNotificationDao.processNotification(id);
    }
}
