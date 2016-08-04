package com.wavemaker.notification.dao.impl;

import com.mongodb.WriteConcern;
import com.mongodb.WriteResult;
import com.wavemaker.notification.dao.PublisherDao;
import com.wavemaker.notification.entity.Publisher;
import com.wavemaker.notification.entity.PublisherStub;
import com.wavemaker.notification.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * Created by tarund on 2/8/16.
 */
@Repository
public class PublisherDaoImpl implements PublisherDao{

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void initMethod(){

        mongoTemplate.setWriteConcern(WriteConcern.ACKNOWLEDGED);
    }

    public static final String COLLECTION_NAME="publishers";

    public Publisher create(Publisher publisher) {
        try{
            mongoTemplate.insert(publisher,COLLECTION_NAME);
        }catch (DataAccessException exception){
           throw new DaoException("Publisher Already exists");
        }

        return publisher;
    }

    public Publisher getPublisher(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query,Publisher.class, COLLECTION_NAME) ;
    }

    public int update( PublisherStub publisherStub) {
        Query query = new Query(Criteria.where("name").is(publisherStub.getName()));
        Update update = new Update();
        update.set("channel",publisherStub.getChannel());
        WriteResult writeResult=mongoTemplate.updateFirst(query,update,COLLECTION_NAME);
        return writeResult.getN();
    }

    public boolean isExists(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        Publisher publisher=mongoTemplate.findOne(query,Publisher.class,COLLECTION_NAME);
        if(null==publisher)
            return false;
        return true;
    }

    public void remove(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        mongoTemplate.remove(query,COLLECTION_NAME);
    }
}
