package com.shiwuliang.confirmOrder;

import com.shiwuliang.BusinessNode;
import com.shiwuliang.RequestContext;
import com.shiwuliang.Response;

/**
 * GetPrepayUserCartNode
 *
 * @author ziyuan
 * @since 2017-03-29
 */
public final class GetPrepayUserCartNode extends BusinessNode {

    public static final GetPrepayUserCartNode INSTANCE = new GetPrepayUserCartNode();

    public static GetPrepayUserCartNode getINSTANCE() {
        return INSTANCE;
    }

    @Override
    protected void handle(RequestContext requestContext, Response response) throws Exception {
        return;
    }
}
