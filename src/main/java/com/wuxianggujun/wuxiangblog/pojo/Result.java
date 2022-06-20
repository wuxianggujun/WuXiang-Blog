package com.wuxianggujun.wuxiangblog.pojo;

public class Result<T> {
    //返回信息
    private String message;

    private int code;

    //数据是否正常请求
    private boolean success;
    //具体返回的数据
    private T detail;

    public Result(boolean success, int code, String message, T detail) {
        this.message = message;
        this.code = code;
        this.success = success;
        this.detail = detail;
    }

    public static Result success(Object data) {
        Result<Object> result = new Result<>(true, 200, "ok", data);
        return result;
    }

    public static Result fail(int code, String msg) {
        Result result = new Result(false, code, msg, null);
        return result;
    }

    public static Result detail(String data) {
        return new Result(false,0,data,null);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getDetail() {
        return detail;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }
}
