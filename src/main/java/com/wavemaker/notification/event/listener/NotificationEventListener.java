package com.wavemaker.notification.event.listener;

import com.wavemaker.notification.event.NotificationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by tarund on 1/7/16.
 */
@Component
public class NotificationEventListener<T extends NotificationEvent> implements ApplicationListener<T>{

    /*@Autowired
    NotificationActionManager notificationActionManager;*/

    public void onApplicationEvent(T event) {
        handleEvent(event);
    }

    protected void handleEvent(T event){
        ArrayList<String> aList = new ArrayList<String>();
        aList.add("3");
       // notificationActionManager.markNotificationsAsRead(aList);
    }
}
