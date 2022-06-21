package com.wuxianggujun.wuxiangblog.result;

/**
 * 封装创建Result对象工具类
 *
 * @author 无相孤君
 * @date 2022/06/20
 */
public class ResultGenerator {

    private static final String DEFAULT_SUCCESS_MESSAGE = "Success";

    //只返回状态
    public static <T> Result<T> getSuccessResult() {
        return new Result<T>()
                .setCode(ResultCode.SUCCESS.code)
                .setSuccess(true)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    //成功返回数据
    public static <T> Result<T> getSuccessResult(T data) {
        return new Result<T>()
                .setCode(ResultCode.SUCCESS.code)
                .setSuccess(true)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setDetail(data);
    }

    //成功返回数据
    public static <T> Result<T> getSuccessResult(String message, T data) {
        return new Result<T>()
                .setCode(ResultCode.SUCCESS.code)
                .setSuccess(true)
                .setMessage(message)
                .setDetail(data);
    }

    // 失败
    public static <T> Result<T> getFailResult(String message) {
        return new Result<T>()
                .setCode(ResultCode.FAIL.code)
                .setSuccess(false)
                .setMessage(message);
    }

    public static <T> Result<T> getFailResult(int code, String message) {
        return new Result<T>()
                .setCode(code)
                .setSuccess(false)
                .setMessage(message);
    }


}
