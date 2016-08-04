package com.wavemaker.notification.controller;

import com.wavemaker.notification.entity.NotificationStub;
import com.wavemaker.notification.entity.Subscription;
import com.wavemaker.notification.entity.User;
import com.wavemaker.notification.entity.types.NotifyType;
import com.wavemaker.notification.entity.SubscriptionStub;
import com.wavemaker.notification.entity.types.PushNotification;
import com.wavemaker.notification.service.SubscriptionService;
import com.wavemaker.notification.test.Project;
import com.wavemaker.notification.test.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by tarund on 13/7/16.
 */
@RestController
@RequestMapping("subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Object> create( @RequestBody SubscriptionStub subscriptionStub){
        Subscription subscription = subscriptionService.subscribe(subscriptionStub);
        return new ResponseEntity<Object>(subscription, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Subscription getSubscription(@PathVariable String name){
        return subscriptionService.getSubscription(name);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
        public boolean isExists(@RequestParam("name") String name){
        return subscriptionService.isExists(name);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public int update(@RequestBody SubscriptionStub subscriptionStub){
        return subscriptionService.update(subscriptionStub);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    public void unsubscribe(@PathVariable String name){
         subscriptionService.unsubscribe(name);
    }


    @RequestMapping(value = "/{channel}/subscribers/",method = RequestMethod.GET)
    public List<Subscription> listSubsribersForChannel(@PathVariable String channel){
       return subscriptionService.listSubsribersForChannel(channel);
    }

   /* @ResponseStatus(value= HttpStatus.CONFLICT, reason="Data already present")
    @ExceptionHandler(RuntimeException.class)
    public void dataConflict() {
    }*/

    @RequestMapping(value = "/dummy/abd",method = RequestMethod.GET)
    public NotificationStub dummy(){
        List<User> receiverList = new LinkedList<User>();
        User user =new User();
        user.setUserId("userId3");
        User user1 = new User();
        user1.setUserId("userId2");
        receiverList.add(user);
        receiverList.add(user1);

        Map<String,Object> arguments = new HashMap<String, Object>();
        arguments.put("u1",new User());
        arguments.put("p1",new Project());
        arguments.put("t1",new Team());

        Map<String,String> actions = new HashMap<String, String>();
        actions.put("JOIN","URL_TO_JOIN");
        actions.put("REJECT","URL_TO_REJECT");


        NotificationStub notificationStub = new NotificationStub();
        notificationStub.setReceivers(receiverList);
        notificationStub.setMessageTemplate("{u1} invited you to join project {p1}");
        notificationStub.setArguments(arguments);
        notificationStub.setActions(actions);
        notificationStub.setNotifyType(NotifyType.ACTION_BASED);




        return notificationStub;
    }

    @RequestMapping(value = "/receiver",method = RequestMethod.POST)
    public void dummyReciever(@RequestBody PushNotification pushNotification){

    }

    /*@RequestMapping(value = "/{channel}/{url}/{notifiedAt}", method = RequestMethod.PUT)
    public int updateLastNotified(@PathVariable String channel, @PathVariable String url,@PathVariable Long notifiedAt){
        return subscriptionService.updateLastNotified(channel,url,notifiedAt);
    }

    @RequestMapping(value = "/notifications/{lastNotifiedAt}", method = RequestMethod.GET)
    public List<Notification> listNotifications(@PathVariable Long lastNotifiedAt){
        return notificationService.listNotifications(lastNotifiedAt);
    }*/

}
