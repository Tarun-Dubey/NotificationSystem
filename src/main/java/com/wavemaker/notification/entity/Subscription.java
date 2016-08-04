package com.wavemaker.notification.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by tarund on 18/7/16.
 */
@Document
public class Subscription {


    @Id
    private String id;
    private String name;
    private String url;
    private String channel;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date subscribedAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date lastNotifiedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Date getSubscribedAt() {
        return subscribedAt;
    }

    public void setSubscribedAt(Date subscribedAt) {
        this.subscribedAt = subscribedAt;
    }

    public Date getLastNotifiedAt() {
        return lastNotifiedAt;
    }

    public void setLastNotifiedAt(Date lastNotifiedAt) {
        this.lastNotifiedAt = lastNotifiedAt;
    }
}
