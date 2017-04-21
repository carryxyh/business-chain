package com.shiwuliang.confirmOrder;

import com.shiwuliang.BusinessNode;
import com.shiwuliang.RequestContext;
import com.shiwuliang.Response;

/**
 * GetNormalUserCartNode
 *
 * @author ziyuan
 * @since 2017-03-29
 */
public final class GetNormalUserCartNode extends BusinessNode {

    public static final GetNormalUserCartNode INSTANCE = new GetNormalUserCartNode();

    public static GetNormalUserCartNode getINSTANCE() {
        return INSTANCE;
    }

    @Override
    protected void handle(RequestContext requestContext, Response response) throws Exception {
        return;
    }
}
