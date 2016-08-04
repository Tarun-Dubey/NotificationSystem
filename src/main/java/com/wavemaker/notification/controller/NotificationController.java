package com.wavemaker.notification.controller;

import com.wavemaker.notification.entity.Notification;
import com.wavemaker.notification.entity.NotificationStub;
import com.wavemaker.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tarund on 28/6/16.
 */

@RestController
@RequestMapping(value="notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public List<Notification> listNotificationsByUserId(@PathVariable String userId) {
        return notificationService.listNotification(userId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void createNotification(@RequestBody NotificationStub notificationStub) {
        notificationService.addNotification(notificationStub);
    }

    @RequestMapping(value = "/{userId}/count", method = RequestMethod.GET)
    public int getUnreadNotificationsCountByUserId(@PathVariable String userId) {
        return notificationService.getUnReadNotificationsCountForUser(userId);
    }
    @RequestMapping(value = "/{notificationId}", method = RequestMethod.PUT)
    public void processNotification(@PathVariable String notificationId) {
        notificationService.processNotification(notificationId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteNotification(@PathVariable String id) {
        notificationService.deleteNotification(id);
    }


}
