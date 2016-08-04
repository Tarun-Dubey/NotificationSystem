package com.wavemaker.notification.entity.types;

import com.wavemaker.notification.entity.NotificationStub;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by tarund on 23/7/16.
 */
public class PushNotification {

    String id;
    NotificationStub payload;
    String subscriberId;
    String subscriberUrl;
    NotificationStatus notificationStatus;
    String channel;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    int retries;
    Boolean isDeleted;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date lastModifiedAt;

    public NotificationStatus getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(NotificationStatus notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NotificationStub getPayload() {
        return payload;
    }

    public void setPayload(NotificationStub payload) {
        this.payload = payload;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getSubscriberUrl() {
        return subscriberUrl;
    }

    public void setSubscriberUrl(String subscriberUrl) {
        this.subscriberUrl = subscriberUrl;
    }


    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
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
