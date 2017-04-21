package com.shiwuliang;

import com.shiwuliang.confirmOrder.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.lang3.StringUtils;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        Channel c = ChannelHolder.getChannel();
        c.addNode(new BusinessNode1());
        c.addNode(new BusinessNode2());
        c.addContextParam("1", 1);
        c.addContextParam("2", 2);

        Response rsp = null;
        try {
            rsp = c.handleRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(rsp.isSuccess());
        ChannelHolder.reset();
    }

    public void testCon() throws Exception {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        testFinal();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        Thread.sleep(20000);
    }

    private void testAsync() throws Exception {
        ConfirmOrderParam orderParam = new ConfirmOrderParam();
        boolean isAddDish = StringUtils.isNotBlank(orderParam.orderId);

        Channel c = ChannelHolder.getChannel();
        c.addContextParam("IsAddDish", isAddDish);
        if (isAddDish) {
            c.addNode(AddDish.getInstance());
        } else {
            c.addNode(Normal.getInstance());
        }
        c.handleRequest();
    }

    static class AddDish extends BusinessNode {

        private AddDish() {
        }

        private static final AddDish INSTANCE = new AddDish();

        public static AddDish getInstance() {
            return INSTANCE;
        }

        @Override
        protected void handle(RequestContext context, Response response) throws Exception {
            boolean isAddDish = (boolean) context.get("IsAddDish");
            if (!isAddDish) {
                System.out.println("error!!!!");
            }
        }
    }

    static class Normal extends BusinessNode {

        private Normal() {
        }

        private static final Normal INSTANCE = new Normal();

        public static Normal getInstance() {
            return INSTANCE;
        }

        @Override
        protected void handle(RequestContext context, Response response) throws Exception {
            boolean isAddDish = (boolean) context.get("IsAddDish");
            if (isAddDish) {
                System.out.println("error!!!!");
            }
        }
    }

    public class ConfirmOrderParam {
        public String orderId = "";
        public String seatCode = "Y12";

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getSeatCode() {
            return seatCode;
        }

        public void setSeatCode(String seatCode) {
            this.seatCode = seatCode;
        }
    }

    public void testFinal() throws Exception {
        ConfirmOrderParam baseParam = new ConfirmOrderParam();
        boolean isCloud = StringUtils.isNotBlank(baseParam.getSeatCode()) || (StringUtils.isNotBlank(baseParam.getOrderId()) && 40 == 0);
        boolean isAddDish = StringUtils.isNotBlank(baseParam.getOrderId());
        Channel c = ChannelHolder.getChannel();

        c.addContextParam(Constants.CONFIRM_PARAM, baseParam);
        c.addContextParam(Constants.IS_CLOUD, isCloud);
        c.addContextParam(Constants.CART_TIMESTAMP, 0);
        c.addContextParam(Constants.IS_PREPAY, false);
        c.addContextParam(Constants.IS_ADD_DISH, isAddDish);

        dealChannel(isCloud, false, isAddDish, c);
        Response response = c.handleRequest();
        System.out.println(response.getModel());
    }

    private void dealChannel(boolean isCloud, boolean isPrepay, boolean isAddDish, Channel c) {

        //购物车检查以及获取购物车部分
        if (isPrepay) {
            //预付款
            if (isCloud) {
                //云购物车
                c.addNode(GetPrepayCloudCartNode.getINSTANCE());
            } else {
                //个人购物车
                c.addNode(GetPrepayUserCartNode.getINSTANCE());
            }
            c.addNode(CheckChangeNode.getINSTANCE());
        } else {
            //非预付款
            c.addNode(CheckChangeNode.getINSTANCE());
            if (isCloud) {
                //云购物车
                c.addNode(GetNormalCloudCartNode.getINSTANCE());
            } else {
                //个人购物车
                c.addNode(GetNormalUserCartNode.getINSTANCE());
            }
        }

        //检查套餐以及拼装数据部分
        c.addNode(SuitMenuCheckNode.getINSTANCE());
        c.addNode(OrderInfoNode.getINSTANCE());

        //下单部分
        if (isPrepay) {
            //预付款
            if (isCloud) {
                if (isAddDish) {
                    //加菜
                    c.addNode(PrepayAddDishNode.getINSTANCE());
                } else {
                    //扫桌码预付款下单
                    c.addNode(PrepayTableOrderSubmitNode.getINSTANCE());
                }
            } else {
                //扫店码预付款下单
                c.addNode(PrepayShopOrderSubmitNode.getINSTANCE());
            }
        } else {
            if (isAddDish) {
                //加菜
                System.out.println("error,isAddDish:" + isAddDish);
                c.addNode(NormalAddDishNode.getINSTANCE());
            } else {
                c.addNode(NormalSubmitOrderNode.getINSTANCE());
            }
        }
        c.addNode(CacheShopCustomerNode.getINSTANCE());
    }
}
