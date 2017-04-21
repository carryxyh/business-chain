package com.shiwuliang.confirmOrder;

import com.shiwuliang.BusinessNode;
import com.shiwuliang.RequestContext;
import com.shiwuliang.Response;

/**
 * OrderInfoNode
 *
 * @author ziyuan
 * @since 2017-03-29
 */
public final class OrderInfoNode extends BusinessNode {

    public static final OrderInfoNode INSTANCE = new OrderInfoNode();

    public static OrderInfoNode getINSTANCE() {
        return INSTANCE;
    }

    @Override
    protected void handle(RequestContext requestContext, Response response) throws Exception {
        return;
    }
}
