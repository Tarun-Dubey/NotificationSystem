package com.wavemaker.notification.manager.impl;

import com.wavemaker.notification.dao.ActivityDao;
import com.wavemaker.notification.entity.Activity;
import com.wavemaker.notification.entity.ActivityStub;
import com.wavemaker.notification.manager.ActivityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by tarund on 26/7/16.
 */
@Service
public class ActivityManagerImpl implements ActivityManager {

    @Autowired
    ActivityDao activityDao;

    public void createActivity(ActivityStub activityStub){
        _createActivity(activityStub);
    }

    private void _createActivity(ActivityStub activityStub){
        Activity activity = new Activity();
        activity.setId(UUID.randomUUID().toString());
        activity.setMessageTemplate(activityStub.getMessageTemplate());
        activity.setArguments(activityStub.getArguments());
        activity.setProviders(activityStub.getProviders());
        activity.setCreatedAt(new Date());
        activityDao.createActivity(activity);
    }

    public List<Activity> listActivities(Map<String, List<String>> providers) {
        return activityDao.listActivities(providers);
    }
}
