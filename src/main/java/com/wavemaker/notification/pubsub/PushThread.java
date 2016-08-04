package com.wavemaker.notification.pubsub;

/**
 * Created by tarund on 1/7/16.
 */

public class PushThread {
    /*@Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;*/


    public void initThread(){

       /* DBCollection coll = mongoTemplate.getCollection("mongocrud");


        DBObject sortBy = BasicDBObjectBuilder.start("$natural", 1).get();


        final DBCursor cur = coll.find().sort(sortBy).addOption(Bytes.QUERYOPTION_TAILABLE).addOption(Bytes.QUERYOPTION_AWAITDATA);



        Runnable task = new Runnable() {
            ApplicationEventPublisher pubsub = applicationEventPublisher;
            public void run() {


                while (cur.hasNext()) {
                    DBObject obj = cur.next();
                    pubsub.publishEvent(new NotificationEvent(this));

                }
            }
        };

        Thread td = new Thread(task);
        td.setDaemon(true);
        td.start();*/
    }
}
