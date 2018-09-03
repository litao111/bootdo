package com.bootdo.common.utils;

import java.io.Serializable;

/**
 * Created by hasee on 2018/8/17.
 */
public class JsonResult implements Serializable {

    public static final Integer SUCCESS = 0;
    public static final Integer ERROR = 1;
    private Integer state;
    private String message;
    private Object data;

    public JsonResult(Throwable e) {
        state = ERROR;
        data = null;
        message = e.getMessage();
    }

    public JsonResult(JsonResultBuilder jsonResultBuilder) {
        this.state = jsonResultBuilder.state;
        this.message = jsonResultBuilder.message;
        this.data = jsonResultBuilder.data;
    }

    public static class JsonResultBuilder {
        private Integer state;
        private String message;
        private Object data;

        public JsonResultBuilder state(Integer state) {
            this.state = state;
            return this;
        }

        public JsonResultBuilder data(Object data) {
            this.data = data;
            return this;
        }

        public JsonResultBuilder message(String message) {
            this.message = message;
            return this;
        }

        public JsonResult build() {
            return new JsonResult(this);
        }
    }

    public Integer getState() {
        return this.state;
    }

    public String getMessage() {
        return this.message;
    }

    public Object getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "state=" + state +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
