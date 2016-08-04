package com.wavemaker.notification.entity;

import com.wavemaker.notification.entity.types.NotificationStatus;
import com.wavemaker.notification.entity.types.NotifyType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Map;

/**
 * Created by tarund on 29/6/16.
 */
@Document
public class Notification {


    @Id
    private String id;
    private String channelId;
    private User receiver;
    private String messageTemplate;
    private Map<String,Object> arguments;
    private Map<String,String> actions;
    private NotifyType notifyType; // {READ_ONLY,ACTION_BASED}
    private NotificationStatus notificationStatus;  //{PENDING,DONE}
    private boolean isRead;
    private Boolean isDeleted;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date lastModifiedAt;

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
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

    public NotificationStatus getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(NotificationStatus notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(Date lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }
}
