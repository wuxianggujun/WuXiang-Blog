package com.wuxianggujun.wuxiangblog.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.wuxianggujun.wuxiangblog.exception.ApiException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * JwtToken工具生成类
 * <p>
 * JwtToken生成的工具类
 * JWT token的格式：header.payload.signature
 * header的格式（算法、token的类型）,默认：{"alg": "HS512","typ": "JWT"}
 * payload的格式 设置：（用户信息、创建时间、生成时间）
 * signature的生成算法：
 * HMACSHA512(base64UrlEncode(header) + "." +base64UrlEncode(payload),secret)
 *
 * @author 无相孤君
 * @date 2022/06/19
 */
@Component
@ConfigurationProperties(prefix = "jwt")
public class JWTUtils {

    /**
     * 定义token返回头部
     */
    public static String header = "Authorization";

    /**
     * token前缀
     */
    public static String tokenPrefix = "WuXiangBlog ";

    /**
     * 签名秘钥
     */
    public static String secret = "3344207732@qq.com";

    /**
     * 有效期
     */
    public static long expireTime = 12 * 60;

    /**
     * 存放客户端的token的key
     */
    public static final String USER_LOGIN_TOKEN = "USER_LOGIN_TOKEN";


    public static void setHeader(String header) {
        JWTUtils.header = header;
    }


    public static void setTokenPrefix(String tokenPrefix) {
        JWTUtils.tokenPrefix = tokenPrefix;
    }


    public static void setSecret(String secret) {
        JWTUtils.secret = secret;
    }


    public static void setExpireTime(long expireTime) {
        JWTUtils.expireTime = expireTime;
    }

    /**
     * 创建令牌
     *
     * @param sub
     * @return {@link String}
     */
    public static String createToken(String sub) {
        return tokenPrefix + JWT.create()
                .withSubject(sub)
                .withExpiresAt(new Date(System.currentTimeMillis() + expireTime))
                .sign(Algorithm.HMAC512(secret));
    }

    /**
     * 验证令牌
     *
     * @param token 令牌
     * @return {@link String}
     */
    public static String validateToken(String token) {
        try {
            return JWT.require(Algorithm.HMAC512(secret))
                    .build()
                    .verify(token.replace(tokenPrefix, ""))
                    .getSubject();
        } catch (TokenExpiredException e) {
            throw new ApiException("Token已经过期！");
        } catch (Exception e) {
            throw new ApiException("Token验证失败！");
        }
    }

    /**
     * 需要更新
     *
     * @param token 令牌
     * @return boolean
     */
    public static boolean isNeedUpdate(String token) {
        //获取token过期时间
        Date expiresAt = null;
        try {
            expiresAt = JWT.require(Algorithm.HMAC512(secret))
                    .build()
                    .verify(token.replace(tokenPrefix, ""))
                    .getExpiresAt();
        } catch (TokenExpiredException e) {
            return true;
        } catch (Exception e) {
            throw new ApiException("token验证失败!");
        }
        //如果剩余过期时间少于过期时常的一般时，需要更新
        return (expiresAt.getTime() - System.currentTimeMillis()) < (expireTime >> 1);
    }

//    public static void main(String[] args) {
//        JWTUtils.setHeader("Authorization");
//        JWTUtils.setTokenPrefix("WuXiangBlog ");
//        JWTUtils.setSecret("3344207732@qq.com");
//        JWTUtils.setExpireTime(1);
//        String token = JWTUtils.createToken("123456");
//        System.out.println(token);
//        System.out.println(JWTUtils.validateToken(token));
//    }
}
