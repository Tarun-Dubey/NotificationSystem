package com.wavemaker.notification.dao;

import com.wavemaker.notification.entity.Activity;

import java.util.List;
import java.util.Map;

/**
 * Created by tarund on 26/7/16.
 */
public interface ActivityDao {
    void createActivity(Activity activity);
    List<Activity> listActivities(Map<String,List<String>> providers);
}
