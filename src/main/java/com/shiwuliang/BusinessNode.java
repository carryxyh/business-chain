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

    }

    /**
     * 真正的处理业务
     */
    public abstract void handle(RequestContext context, Response response) throws Exception;
}
