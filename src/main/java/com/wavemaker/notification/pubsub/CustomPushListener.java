package com.wavemaker.notification.pubsub;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by tarund on 1/7/16.
 */
public class CustomPushListener implements ServletContextListener {



    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext sc = servletContextEvent.getServletContext();

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
