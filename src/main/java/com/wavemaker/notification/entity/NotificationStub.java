package com.wavemaker.notification.entity;

import com.wavemaker.notification.entity.types.NotifyType;

import java.util.List;
import java.util.Map;

/**
 * Created by tarund on 15/7/16.
 */
public class NotificationStub {

    private boolean isPushNotification;
    private List<String> channelIds;
    private List<User> receivers;
    private String messageTemplate;
    private Map<String,Object> arguments;
    private Map<String,String> actions;
    private NotifyType notifyType; // {READ_ONLY,ACTION_BASED}

    public List<String> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<String> channelId) {
        this.channelIds = channelId;
    }

    public List<User> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<User> receivers) {
        this.receivers = receivers;
    }

    public String getMessageTemplate() {
        return messageTemplate;
    }

    public void setMessageTemplate(String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public Map<String, Object> getArguments() {
        return arguments;
    }

    public void setArguments(Map<String, Object> arguments) {
        this.arguments = arguments;
    }

    public Map<String, String> getActions() {
        return actions;
    }

    public void setActions(Map<String, String> actions) {
        this.actions = actions;
    }

    public NotifyType getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(NotifyType notifyType) {
        this.notifyType = notifyType;
    }

    public boolean isPushNotification() {
        return isPushNotification;
    }

    public void setPushNotification(boolean pushNotification) {
        isPushNotification = pushNotification;
    }
}
