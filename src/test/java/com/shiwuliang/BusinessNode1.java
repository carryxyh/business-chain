package com.shiwuliang;

/**
 * BusinessNode1
 *
 * @author ziyuan
 * @since 2017-03-25
 */
public class BusinessNode1 extends BusinessNode {

    protected void handle(RequestContext context, Response response) throws Exception {
        System.out.println("1");
        ChannelHolder.done();
    }
}
