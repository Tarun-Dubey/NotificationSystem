package com.wavemaker.notification.manager;

import com.wavemaker.notification.entity.Activity;
import com.wavemaker.notification.entity.ActivityStub;

import java.util.List;
import java.util.Map;

/**
 * Created by tarund on 26/7/16.
 */
public interface ActivityManager {
    void createActivity(ActivityStub activityStub);
    List<Activity> listActivities(Map<String,List<String>> providers);
}
