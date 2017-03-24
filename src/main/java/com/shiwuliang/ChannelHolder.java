package com.shiwuliang;

/**
 * ChannelHolder
 *
 * @author ziyuan
 * @since 2017-03-24
 */
public final class ChannelHolder {

    private ThreadLocal<Channel> holders;

    private ThreadLocal<Boolean> localDone;


}
