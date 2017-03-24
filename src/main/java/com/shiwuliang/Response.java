package com.shiwuliang;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Response
 *
 * @author ziyuan
 * @since 2017-03-24
 */
public final class Response<T> implements Serializable {

    /**
     * 1成功 2失败
     */
    private int state = 1;

    @Setter
    @Getter
    private T model;

    /**
     * rsp是否成功
     *
     * @return 是否成功
     */
    public boolean isSuccess() {
        return this.state == 1;
    }

    /**
     * rsp是否失败
     *
     * @return 是否失败
     */
    public boolean isFail() {
        return !isSuccess();
    }

    /**
     * 把rsp置为失败
     */
    public void fail() {
        this.state = this.state << 1;
    }

    /**
     * 把rsp置为失败
     *
     * @param model model
     */
    public void fail(T model) {
        this.model = model;
        this.state = this.state << 1;
    }
}
