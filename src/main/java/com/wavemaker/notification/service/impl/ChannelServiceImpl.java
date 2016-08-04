package com.wavemaker.notification.service.impl;

import com.wavemaker.notification.entity.Channel;
import com.wavemaker.notification.entity.ChannelStub;
import com.wavemaker.notification.manager.ChannelManager;
import com.wavemaker.notification.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tarund on 2/8/16.
 */
@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    ChannelManager channelManager;

    public Channel create(ChannelStub channelStub){
        return channelManager.create(channelStub);
    }

    public boolean update(ChannelStub channelStub) {
        return channelManager.update(channelStub);
    }

    public boolean isExists(String name) {
        return channelManager.isExists(name);
    }

    public Channel getChannel(String name) {
        return channelManager.getChannel(name);
    }

    public void remove(String name) {
        channelManager.remove(name);
    }

    public List<Channel> listChannels() {
        return channelManager.listChannels();
    }

}
