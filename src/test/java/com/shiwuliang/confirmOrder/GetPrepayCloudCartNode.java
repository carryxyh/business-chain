package com.shiwuliang.confirmOrder;

import com.shiwuliang.BusinessNode;
import com.shiwuliang.RequestContext;
import com.shiwuliang.Response;

/**
 * GetPrepayCloudCartNode
 *
 * @author ziyuan
 * @since 2017-03-29
 */
public final class GetPrepayCloudCartNode extends BusinessNode {

    public static final GetPrepayCloudCartNode INSTANCE = new GetPrepayCloudCartNode();

    public static GetPrepayCloudCartNode getINSTANCE() {
        return INSTANCE;
    }

    @Override
    protected void handle(RequestContext requestContext, Response response) throws Exception {
        return;
    }
}
