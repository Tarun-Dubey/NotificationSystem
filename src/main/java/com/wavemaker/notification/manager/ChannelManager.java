package com.wavemaker.notification.manager;

import com.wavemaker.notification.entity.Channel;
import com.wavemaker.notification.entity.ChannelStub;

import java.util.List;

/**
 * Created by tarund on 2/8/16.
 */
public interface ChannelManager {

    Channel create(ChannelStub channelStub);
    boolean update(ChannelStub channelStub);
    boolean isExists(String name);
    Channel getChannel(String name);
    void remove(String name);
    List<Channel> listChannels();

}
