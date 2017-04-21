package com.shiwuliang.confirmOrder;

import com.shiwuliang.BusinessNode;
import com.shiwuliang.RequestContext;
import com.shiwuliang.Response;

/**
 * GetNormalCloudCartNode
 *
 * @author ziyuan
 * @since 2017-03-29
 */
public final class GetNormalCloudCartNode extends BusinessNode {

    public static final GetNormalCloudCartNode INSTANCE = new GetNormalCloudCartNode();

    public static GetNormalCloudCartNode getINSTANCE() {
        return INSTANCE;
    }

    @Override
    protected void handle(RequestContext requestContext, Response response) throws Exception {
        return;
    }
}
