package com.wavemaker.notification.pubsub;

import com.wavemaker.notification.entity.types.PushNotification;
import com.wavemaker.notification.manager.PushNotificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tarund on 28/7/16.
 */
@Component
@Scope("prototype")
public class PublisherTask implements Runnable {

    @Autowired
    PushNotificationManager pushNotificationManager;

    public void run() {

        RestTemplate restTemplate = new RestTemplate();
        List<PushNotification> list = new LinkedList<PushNotification>();

        while (true) {


            list = pushNotificationManager.listPendingNotifications();


                for(PushNotification pushNotification : list){
                    try {
                        HttpEntity requestEntity = new HttpEntity(pushNotification);
                        ResponseEntity responseEntity = restTemplate.exchange(pushNotification.getSubscriberUrl(), HttpMethod.POST, requestEntity, String.class);
                        if (responseEntity != null && responseEntity.getStatusCode().value() == 200) {
                            pushNotificationManager.processNotification(pushNotification.getId());
                        }
                    }catch(RestClientException e){
                        ;
                    }
                }

            list.clear();

        }
    }
}
