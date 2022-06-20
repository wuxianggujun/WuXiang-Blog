package com.wuxianggujun.wuxiangblog.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {
    //返回信息
    private String message = "success";

    private int code = -1;

    //数据是否正常请求
    private boolean success = false;
    //具体返回的数据
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private T detail = null;

    public String getMessage() {
        return message;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Result<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public Result<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public Object getDetail() {
        return detail;
    }

    public Result<T> setDetail(T detail) {
        this.detail = detail;
        return this;
    }

}
