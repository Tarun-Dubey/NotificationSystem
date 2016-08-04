package com.wavemaker.notification.controller;

import com.wavemaker.notification.entity.Channel;
import com.wavemaker.notification.entity.ChannelStub;
import com.wavemaker.notification.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tarund on 2/8/16.
 */
@RestController
@RequestMapping("channels")
public class ChannelController {

    @Autowired
    ChannelService channelService;
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody ChannelStub channelStub){
        Channel channel = channelService.create(channelStub);
        return new ResponseEntity<Object>(channel,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public boolean update(@RequestBody ChannelStub channelStub){
        return channelService.update(channelStub);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public boolean isExists(@RequestParam String name){
        return channelService.isExists(name);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Channel getChannel(@PathVariable String name){
        return channelService.getChannel(name);
    }


    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    public void remove(@PathVariable String name){
        channelService.remove(name);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Channel> listChannels(){
        return channelService.listChannels();
    }
}
