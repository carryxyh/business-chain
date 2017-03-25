package com.shiwuliang;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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

        Response rsp = c.handleRequest();
        System.out.println(rsp.isSuccess());
        ChannelHolder.reset();
    }
}
