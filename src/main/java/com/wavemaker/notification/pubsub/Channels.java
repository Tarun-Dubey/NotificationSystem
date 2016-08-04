package com.wavemaker.notification.pubsub;

/**
 * Created by tarund on 28/7/16.
 */
public enum Channels {
    CHANNEL_ONE("channelname");

    private final String channelName;

    Channels(String channelName){
        this.channelName=channelName;
    }

    public String getChannelName(){
        return channelName;
    }

    /**
     * @return the name of this enum constant with quoted.
     */
    @Override
    public String toString() {
        return "'" + super.name() + "'";
    }
}
