package com.wuxianggujun.wuxiangblog.pojo;

import com.wuxianggujun.wuxiangblog.entity.User;

public class ResultInfo {
    public static ResultInfo success(User user) {
        return new ResultInfo();
    }
}
