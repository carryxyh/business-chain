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
     * 头节点
     */
    private BusinessNode head;

    @Getter
    private RequestContext context = new RequestContext();

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
        if (head == null) {
            this.head = node;
        } else {
            this.tail.setNext(node);
        }
        this.tail = node;
    }

    public Response handleRequest() {
        Response res = new Response();
        if (head == null) {
            return res;
        }
        try {
            head.handleRequest(this.context, res);
        } catch (Exception e) {

            exHandler.onException(e);
        }

        return res;
    }
}
