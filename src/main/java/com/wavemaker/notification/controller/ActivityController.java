package com.wavemaker.notification.controller;

import com.wavemaker.notification.entity.Activity;
import com.wavemaker.notification.entity.ActivityStub;
import com.wavemaker.notification.entity.User;
import com.wavemaker.notification.service.ActivityService;
import com.wavemaker.notification.test.Project;
import com.wavemaker.notification.test.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tarund on 26/7/16.
 */
@RestController
@RequestMapping("activities")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public void addActivity(@RequestBody ActivityStub activityStub){
        activityService.createActivity(activityStub);
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public List<Activity> listActivities(@PathVariable String userId, @MatrixVariable Map<String,List<String>> providers){
        Map<String,List<String>> a = providers;
        return activityService.listActivities(providers);
    }

    @RequestMapping(value = "/dummy/{projects}",method = RequestMethod.GET)
    public String dummy(@PathVariable List<String> projects){
        List<String> a = projects;
        return "success";
    }

    @RequestMapping(value = "/dummy",method = RequestMethod.GET)
    public ActivityStub dummy(){

        Map<String,Object> arguments = new HashMap<String, Object>();
        arguments.put("u1",new User());
        arguments.put("p1",new Project());
        arguments.put("t1",new Team());

        Map<String,String> providers = new HashMap<String, String>();
        providers.put("team","team1");
        providers.put("project","project1");

        ActivityStub activityStub = new ActivityStub();
        activityStub.setMessageTemplate("{u1} invited you to join project {p1}");
        activityStub.setArguments(arguments);
        activityStub.setProviders(providers);



        return activityStub;
    }

}
