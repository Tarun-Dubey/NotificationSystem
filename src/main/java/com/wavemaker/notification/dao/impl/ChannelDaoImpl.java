package com.wavemaker.notification.dao.impl;

import com.mongodb.WriteConcern;
import com.wavemaker.notification.dao.ChannelDao;
import com.wavemaker.notification.entity.Channel;
import com.wavemaker.notification.entity.ChannelStub;
import com.wavemaker.notification.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by tarund on 2/8/16.
 */
@Repository
public class ChannelDaoImpl implements ChannelDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void initMethod(){

        mongoTemplate.setWriteConcern(WriteConcern.ACKNOWLEDGED);
    }

    public static final String COLLECTION_NAME="channels";

    public Channel create(Channel channel) {
        try{
            mongoTemplate.insert(channel,COLLECTION_NAME);
        }catch (DataAccessException exception){
            throw new DaoException("Channel already exists");
        }

        return channel;
    }


    // TODO: 2/8/16 changes need to be done
    public boolean update(ChannelStub channelStub) {
        /*Query query = new Query(Criteria.where("name").is(channelStub.getName()));
        Update update = new Update();
        update.set("somefield",subscriptionStub.getsomefield);
        WriteResult writeResult=mongoTemplate.updateFirst(query,update,COLLECTION_NAME);
       if( writeResult.getN()>0)
           return true;*/
        return false;
    }

    public boolean isExists(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        Channel channel=mongoTemplate.findOne(query,Channel.class,COLLECTION_NAME);
        if(null==channel)
            return false;
        return true;
    }

    public Channel getChannel(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query,Channel.class, COLLECTION_NAME) ;
    }

    public void remove(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        mongoTemplate.remove(query,COLLECTION_NAME);
    }

    public List<Channel> listChannels() {
        return mongoTemplate.findAll(Channel.class,COLLECTION_NAME);
    }
}
