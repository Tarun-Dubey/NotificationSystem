package com.wavemaker.notification.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tarund on 13/7/16.
 */
@Component
@DependsOn("mongoTemplate")
public class PubSubPublisher {
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    PublisherTask publisherTask ;

    private ExecutorService executorService;

    @PostConstruct
    public void initPublisher(){

        executorService = Executors.newFixedThreadPool(1);
        executorService.execute(publisherTask);
    }

    @PreDestroy
    public void cleanUp() {
        executorService.shutdownNow();
    }


}
