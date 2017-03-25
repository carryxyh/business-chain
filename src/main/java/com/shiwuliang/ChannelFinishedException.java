package com.shiwuliang;

/**
 * ChannelFinishedException
 *
 * @author ziyuan
 * @since 2017-03-25
 */
public class ChannelFinishedException extends RuntimeException{

    public ChannelFinishedException() {
        super("Channel is running !");
    }
}
