package com.shiwuliang;

import lombok.Getter;
import lombok.Setter;

/**
 * Channel
 *
 * @author ziyuan
 * @since 2017-03-24
 */
public class Channel {

    @Getter
    @Setter
    private ExceptionHandler exHandler = new ExceptionHandler() {

        public void onException(Exception ex) {
            ex.printStackTrace();
        }
    };

    /**
     * 1运行中 2结束
     */
    private int state = 1;

    @Getter
    private RequestContext context = new RequestContext();

    /**
     * 头节点
     */
    private BusinessNode head;

    /**
     * 尾节点
     */
    private BusinessNode tail;

    /**
     * 向管道中添加节点
     *
     * @param node 节点
     */
    public void addNode(BusinessNode node) {
        if (this.state == 2) {
            throw new ChannelFinishedException();
        }
        if (head == null) {
            this.head = node;
        } else {
            this.tail.setNext(node);
        }
        this.tail = node;
    }

    /**
     * 添加param
     *
     * @param k key
     * @param v value
     */
    public void addContextParam(String k, Object v) {
        if (this.state == 2) {
            throw new ChannelRunningException();
        }
        this.context.putIfAbsent(k, v);
    }

    public synchronized Response handleRequest() {
        Response res = new Response();
        if (this.state == 2) {
            return res;
        }
        if (head == null) {
            return res;
        }

        try {
            head.handleRequest(this.context, res);
        } catch (Exception e) {
            res.fail();
            exHandler.onException(e);
        }
        this.state = this.state << 1;
        ChannelHolder.done();
        return res;
    }
}
