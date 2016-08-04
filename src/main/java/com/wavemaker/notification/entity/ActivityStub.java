package com.wavemaker.notification.entity;

import java.util.Map;

/**
 * Created by tarund on 26/7/16.
 */
public class ActivityStub {

    private String messageTemplate;
    private Map<String,Object> arguments;
    private Map<String,String> providers;

    public String getMessageTemplate() {
        return messageTemplate;
    }

    public void setMessageTemplate(String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public Map<String, Object> getArguments() {
        return arguments;
    }

    public void setArguments(Map<String, Object> arguments) {
        this.arguments = arguments;
    }

    public Map<String, String> getProviders() {
        return providers;
    }

    public void setProviders(Map<String, String> providers) {
        this.providers = providers;
    }
}
