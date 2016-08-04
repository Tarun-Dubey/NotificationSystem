package com.wavemaker.notification.dao.impl;

import com.mongodb.WriteResult;
import com.wavemaker.notification.dao.NotificationDao;
import com.wavemaker.notification.entity.Notification;
import com.wavemaker.notification.entity.types.NotificationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by tarund on 29/6/16.
 */
@Repository
public class NotificationDaoImpl implements NotificationDao {

    @Autowired
    private MongoOperations mongoTemplate;

    public static final String COLLECTION_NAME="notification";

    @PostConstruct
    public void init() {
        if (!mongoTemplate.collectionExists(Notification.class)) {
            mongoTemplate.createCollection(Notification.class);
        }
    }

    public void addNotification(Notification notification) {
        mongoTemplate.insert(notification, COLLECTION_NAME);
    }

    public List<Notification> listNotification(String userId) {
        Query query = new Query(Criteria.where("receiver.userId").is(userId).andOperator(Criteria.where("notificationStatus").is("PENDING")));
        return mongoTemplate.find(query,Notification.class, COLLECTION_NAME) ;
    }

    public int getUnReadNotificationsCountForUser(String userId){
        Query query = new Query(Criteria.where("receiver.userId").is(userId).andOperator(Criteria.where("notificationStatus").is("PENDING")));
        return (int) mongoTemplate.count(query, Notification.class, COLLECTION_NAME);
    }

    public void processNotification(String notificationId){
        Query query = new Query(Criteria.where("_id").is(notificationId));
        Update update = new Update();
        update.set("notificationStatus", NotificationStatus.DONE);
        WriteResult result =mongoTemplate.updateFirst(query,update,Notification.class,COLLECTION_NAME);
    }


    public int deleteNotification(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        WriteResult result = mongoTemplate.remove(query, Notification.class, COLLECTION_NAME);
        return result.getN();

    }


    /*public List<PushNotification> listPendingNotifications(String channel){
        Query query = new Query(Criteria.where("notificationStatus").is(NotificationStatus.PENDING));
        return  mongoTemplate.find(query,PushNotification.class,channel);
    }

    public  List<Subscription> listSubscribers(String channel){
        Query query = new Query(Criteria.where("channel").is(channel));
        return mongoTemplate.find(query,Subscription.class,"subscription");
    }


    public void updateNotification(String action,String notificationId) {
        Query query = new Query(Criteria.where("_id").is(notificationId));
        Update update = new Update();
        update.set("notificationStatus",action);
        WriteResult result =mongoTemplate.updateFirst(query,update,Notification.class,COLLECTION_NAME);
    }
    public void updateNotification(Notification notification) {
        mongoTemplate.save(notification,COLLECTION_NAME);
    }

    public List<Notification> listNotifications(Long lastNotifiedAt){
        Query query = new Query(Criteria.where("createdAt").gt(new Date(lastNotifiedAt)));
        return mongoTemplate.find(query,Notification.class,COLLECTION_NAME);
    }
*/



}
