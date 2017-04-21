package com.shiwuliang.confirmOrder;

import com.shiwuliang.BusinessNode;
import com.shiwuliang.RequestContext;
import com.shiwuliang.Response;

/**
 * CheckChangeNode
 *
 * @author ziyuan
 * @since 2017-03-29
 */
public final class CheckChangeNode extends BusinessNode {

    public static final CheckChangeNode INSTANCE = new CheckChangeNode();

    public static CheckChangeNode getINSTANCE() {
        return INSTANCE;
    }

    @Override
    protected void handle(RequestContext requestContext, Response response) throws Exception {
        return;
    }
}
