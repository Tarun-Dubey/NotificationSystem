package com.wavemaker.notification.dao.impl;

import com.mongodb.WriteConcern;
import com.mongodb.WriteResult;
import com.wavemaker.notification.dao.SubscriptionDao;
import com.wavemaker.notification.entity.Subscription;
import com.wavemaker.notification.entity.SubscriptionStub;
import com.wavemaker.notification.entity.types.NotificationStatus;
import com.wavemaker.notification.entity.types.PushNotification;
import com.wavemaker.notification.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;


/**
 * Created by tarund on 18/7/16.
 */
@Repository
public class SubscriptionDaoImpl implements SubscriptionDao{

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void initMethod(){

        mongoTemplate.setWriteConcern(WriteConcern.ACKNOWLEDGED);
    }

    public static final String COLLECTION_NAME="subscription";

    public Subscription subscribe(Subscription subscription){
        try{
            mongoTemplate.insert(subscription,COLLECTION_NAME);
        }catch (DataAccessException exception){
            throw new DaoException("Subscription Already Exists");
        }

        return subscription;

    }
    public Subscription getSubscription(String name){
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query,Subscription.class, COLLECTION_NAME) ;
    }
    public int update( SubscriptionStub subscriptionStub){
        Query query = new Query(Criteria.where("name").is(subscriptionStub.getName()));
        Update update = new Update();
        update.set("url",subscriptionStub.getUrl());
        WriteResult writeResult=mongoTemplate.updateFirst(query,update,COLLECTION_NAME);
        return writeResult.getN();
    }

    public boolean isExists(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        Subscription subscription=mongoTemplate.findOne(query,Subscription.class,COLLECTION_NAME);
        if(null==subscription)
            return false;
        return true;
    }

    public void unsubscribe(String name){
        Query query = new Query(Criteria.where("name").is(name));
        mongoTemplate.remove(query,COLLECTION_NAME);
    }

    public List<Subscription> listSubsribersForChannel(String channel){

        Query query = new Query(Criteria.where("channel").is(channel));
        //query.fields().include("url");
        return mongoTemplate.find(query,Subscription.class,COLLECTION_NAME);
    }



    public List<PushNotification> listPendingNotifications(String channel){
        Query query = new Query(Criteria.where("notificationStatus").is(NotificationStatus.PENDING));
        return  mongoTemplate.find(query,PushNotification.class,channel);
    }

   /* public int updateLastNotified(String channel,String url,Long notifiedAt){
        Query query = new Query(Criteria.where("channel").is(channel).andOperator(Criteria.where("url").is(url)));
        Update update = new Update();
        update.set("lastNotifiedAt",new Date(notifiedAt));
        WriteResult result =mongoTemplate.updateFirst(query,update,Subscription.class,COLLECTION_NAME);
        return result.getN();
    }*/
}
