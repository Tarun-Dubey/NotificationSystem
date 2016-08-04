package com.wavemaker.notification.dao.impl;

import com.wavemaker.notification.dao.PushNotificationDao;
import com.wavemaker.notification.entity.types.NotificationStatus;
import com.wavemaker.notification.entity.types.PushNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tarund on 2/8/16.
 */
@Repository
public class PushNotificationDaoImpl implements PushNotificationDao {

    @Autowired
    private MongoOperations mongoTemplate;

    public static final String COLLECTION_NAME="pushnotifications";

    public void addNotification(PushNotification pushNotification) {
        mongoTemplate.insert(pushNotification, COLLECTION_NAME);
    }

    public List<PushNotification> listPendingNotifications(){
        Query query = new Query(Criteria.where("notificationStatus").is(NotificationStatus.PENDING));
        return  mongoTemplate.find(query,PushNotification.class,COLLECTION_NAME);
    }

    public void processNotification(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        update.set("notificationStatus",NotificationStatus.DONE);
        mongoTemplate.updateFirst(query,update,COLLECTION_NAME);
    }

}
