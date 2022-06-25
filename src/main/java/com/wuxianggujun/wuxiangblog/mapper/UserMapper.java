package com.wuxianggujun.wuxiangblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuxianggujun.wuxiangblog.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户映射器
 *
 * @author 无相孤君
 * @date 2022/06/17
 */
//@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
