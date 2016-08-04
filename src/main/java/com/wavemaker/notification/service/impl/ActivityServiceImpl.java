package com.wavemaker.notification.service.impl;

import com.wavemaker.notification.entity.Activity;
import com.wavemaker.notification.entity.ActivityStub;
import com.wavemaker.notification.manager.ActivityManager;
import com.wavemaker.notification.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by tarund on 26/7/16.
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityManager activityManager;

    public  void createActivity(ActivityStub activityStub){
        activityManager.createActivity(activityStub);

    }


    public List<Activity> listActivities(Map<String, List<String>> providers) {
        return activityManager.listActivities(providers);
    }
}
