package com.shiwuliang.confirmOrder;

import com.shiwuliang.BusinessNode;
import com.shiwuliang.RequestContext;
import com.shiwuliang.Response;

/**
 * CacheShopCustomerNode
 *
 * @author ziyuan
 * @since 2017-04-14
 */
public final class CacheShopCustomerNode extends BusinessNode {

    public static final CacheShopCustomerNode INSTANCE = new CacheShopCustomerNode();

    public static CacheShopCustomerNode getINSTANCE() {
        return INSTANCE;
    }

    @Override
    protected void handle(RequestContext requestContext, Response response) throws Exception {
        return;
    }
}
