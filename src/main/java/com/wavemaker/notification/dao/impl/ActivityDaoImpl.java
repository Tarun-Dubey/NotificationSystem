package com.wavemaker.notification.dao.impl;

import com.wavemaker.notification.dao.ActivityDao;
import com.wavemaker.notification.entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tarund on 26/7/16.
 */
@Repository
public class ActivityDaoImpl implements ActivityDao {

    @Autowired
    private MongoOperations mongoTemplate;

    public static final String COLLECTION_NAME="activity";

    public void createActivity(Activity activity){
        mongoTemplate.insert(activity,COLLECTION_NAME);
    }

    public List<Activity> listActivities(Map<String, List<String>> providers) {
        List<Criteria> providerCriterias = new ArrayList<Criteria>(providers.size());
        for(Map.Entry<String,List<String>> entry : providers.entrySet()){
            providerCriterias.add(Criteria.where("providers."+entry.getKey()).in(entry.getValue()));
        }
        Criteria criteria = new Criteria();
        criteria=criteria.orOperator(providerCriterias.toArray(new Criteria[providers.size()]));
        Query query = new Query(criteria);

        return mongoTemplate.find(query,Activity.class,COLLECTION_NAME);
    }


}
