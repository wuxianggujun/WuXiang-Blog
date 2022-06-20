package com.wuxianggujun.wuxiangblog.result;


/**
 * 自定义响应码枚举
 *
 * @author 无相孤君
 * @date 2022/06/20
 */
public enum ResultCode {
    SUCCESS(200),//成功
    FAIL(400),//失败
    UNAUTHORIZED(401),//未认证（签名错误）
    NOT_FOUND(404),//接口不存在
    INTERNAL_SERVER_ERROR(500);//服务器内部错误

    public final int code;

    ResultCode(int code) {
        this.code = code;
    }
}
