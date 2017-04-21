package com.shiwuliang.confirmOrder;

import com.shiwuliang.AppTest;
import com.shiwuliang.RequestContext;
import com.shiwuliang.Response;
import com.shiwuliang.confirmOrder.base.BaseSubmitOrderNode;
import com.twodfire.share.result.Result;
import com.twodfire.share.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * NormalAddDishNode
 *
 * @author ziyuan
 * @since 2017-03-29
 */
public final class NormalAddDishNode extends BaseSubmitOrderNode {

    public static final NormalAddDishNode INSTANCE = new NormalAddDishNode();

    public static NormalAddDishNode getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public Result<String> submitOrder(RequestContext requestContext, Response response) {

        AppTest.ConfirmOrderParam param = (AppTest.ConfirmOrderParam) requestContext.get(Constants.CONFIRM_PARAM);

        boolean isPrepay = (boolean) requestContext.get(Constants.IS_PREPAY);
        boolean isAddDish = (boolean) requestContext.get(Constants.IS_ADD_DISH);

        if (!isAddDish || isPrepay) {
            System.out.println("normal add dish error, isAddDish:" + isAddDish + ",isPrepay:" + isPrepay + ",baseParam.orderId:" + param.orderId + ",orderId is Blank:" + StringUtils.isBlank(param.orderId));
            return ResultUtil.failResult("normal add dish error");
        }

        return ResultUtil.successResult("normal add dish success");
    }
}
