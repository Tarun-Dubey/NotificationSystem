package com.wavemaker.notification.manager.impl;

import com.wavemaker.notification.dao.ChannelDao;
import com.wavemaker.notification.entity.Channel;
import com.wavemaker.notification.entity.ChannelStub;
import com.wavemaker.notification.manager.ChannelManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by tarund on 2/8/16.
 */
@Service
public class ChannelManagerImpl implements ChannelManager {

    @Autowired
    ChannelDao channelDao;

    public Channel create(ChannelStub channelStub) {
        return _create(channelStub);
    }

    public boolean update(ChannelStub channelStub) {
        return channelDao.update(channelStub);
    }

    public boolean isExists(String name) {
        return channelDao.isExists(name);
    }

    private Channel _create(ChannelStub channelStub){
        Channel channel = new Channel();
        channel.setId(UUID.randomUUID().toString());
        channel.setName(channelStub.getName());
        channel.setCreatedAt(new Date());
       return channelDao.create(channel);
    }

    public Channel getChannel(String name) {
        return channelDao.getChannel(name);
    }

    public void remove(String name) {
        channelDao.remove(name);
    }

    public List<Channel> listChannels() {
        return channelDao.listChannels();
    }
}
