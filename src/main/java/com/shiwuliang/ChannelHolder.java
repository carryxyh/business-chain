package com.shiwuliang;

/**
 * ChannelHolder
 *
 * @author ziyuan
 * @since 2017-03-24
 */
public final class ChannelHolder {

    /**
     * 当前现场的channel
     */
    private static ThreadLocal<Channel> holders = new ThreadLocal<Channel>();

    /**
     * 当前线程是否执行完成
     */
    private static ThreadLocal<Boolean> localDone = new ThreadLocal<Boolean>();

    /**
     * 单例
     */
    private ChannelHolder() {
    }

    /**
     * 结束当前线程的channel
     */
    public static void done() {
        localDone.set(true);
    }

    /**
     * 当前线程是否执行完成
     *
     * @return 是否执行完成
     */
    public static boolean isDone() {
        return localDone.get();
    }

    /**
     * 获取当前现场的channel
     *
     * @return channelo
     */
    public static Channel getChannel() {
        return holders.get();
    }

    /**
     * 重置当前线程的一些参数
     */
    public void reset() {
        holders.remove();
        localDone.remove();
    }
}
