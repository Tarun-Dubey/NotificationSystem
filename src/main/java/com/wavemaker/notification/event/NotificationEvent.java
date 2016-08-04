package com.wavemaker.notification.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by tarund on 1/7/16.
 */

public class NotificationEvent extends ApplicationEvent{

    public NotificationEvent(Object source){
        super(source);
    }
}
