package com.shiwuliang;

import lombok.Getter;
import lombok.Setter;

/**
 * BusinessNode
 *
 * @author ziyuan
 * @since 2017-03-24
 */
public abstract class BusinessNode {

    @Getter
    @Setter
    private BusinessNode next;

    /**
     * 处理
     *
     * @param context
     * @return
     */
    public final void handleRequest(RequestContext context, Response response) throws Exception {
        this.handle(context, response);
        this.hook(context);
        if (this.next != null && !ChannelHolder.isDone()) {
            next.handleRequest(context, response);
        }
    }

    /**
     * 真正的处理业务
     */
    protected abstract void handle(RequestContext context, Response response) throws Exception;

    /**
     * 节点之后的钩子
     * 例子：
     * 执行节点X之后要发消息，我们就可以解耦发消息的内容，将其放到钩子中
     */
    protected void hook(RequestContext context) throws Exception {
    }
}
