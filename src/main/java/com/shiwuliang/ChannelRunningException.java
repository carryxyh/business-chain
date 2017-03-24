package com.shiwuliang;

/**
 * ChannelRunningException
 *
 * @author ziyuan
 * @since 2017-03-24
 */
public class ChannelRunningException extends RuntimeException {

    public ChannelRunningException() {
        super("Channel is running !");
    }
}
