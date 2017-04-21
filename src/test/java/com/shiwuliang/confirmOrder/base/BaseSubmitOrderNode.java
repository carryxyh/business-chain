package com.shiwuliang.confirmOrder.base;

import com.shiwuliang.BusinessNode;
import com.shiwuliang.ChannelHolder;
import com.shiwuliang.RequestContext;
import com.shiwuliang.Response;

/**
 * BaseSubmitOrderNode
 *
 * @author ziyuan
 * @since 2017-03-29
 */
public abstract class BaseSubmitOrderNode extends BusinessNode {

    @Override
    protected void handle(RequestContext requestContext, Response response) throws Exception {
        try {

            Result<String> submitResult = submitOrder(requestContext, response);
            if (!ResultUtil.isResultSuccess(submitResult)) {
                System.out.println("submit order error------------------------------------------------------------!!!!");
                response.fail(submitResult);
                ChannelHolder.done();
                return;
            }

            response.setModel("Internal submit order success ---------");
            return;
        } catch (Exception e) {
            System.out.println("Internal submit order error");
            response.fail("Internal submit order error");
            ChannelHolder.done();
            return;
        }
    }

    public abstract Result<String> submitOrder(RequestContext requestContext, Response response);

    /*------------------------------------------------------------------------------------------*/
}
