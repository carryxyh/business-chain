package com.shiwuliang.confirmOrder;

import com.shiwuliang.BusinessNode;
import com.shiwuliang.RequestContext;
import com.shiwuliang.Response;

/**
 * SuitMenuCheckNode
 *
 * @author ziyuan
 * @since 2017-03-29
 */
public final class SuitMenuCheckNode extends BusinessNode {

    public static final SuitMenuCheckNode INSTANCE = new SuitMenuCheckNode();

    public static SuitMenuCheckNode getINSTANCE() {
        return INSTANCE;
    }

    @Override
    protected void handle(RequestContext requestContext, Response response) throws Exception {
        return;
    }
}
