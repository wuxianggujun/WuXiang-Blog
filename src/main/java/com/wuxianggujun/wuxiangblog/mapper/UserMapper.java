package com.wuxianggujun.wuxiangblog.mapper;

import com.wuxianggujun.wuxiangblog.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
public interface UserMapper {

    //结果映射列表
    @Results({ //2
            @Result(property = "id", column = "id"), //2
            @Result(property = "username", column = "username"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "create_time", column = "create_time"),
            @Result(property = "type", column = "type"),
    })
    /**
     * 查询所有
     * MyBatis面向接口编程的两个一致
     * 1.Mapper接口与xml映射文件的namespace全类名保持一致
     * 2.映射文件中SQL语句的id要和mapper接口中的方法一致
     *
     * @return {@link List}<{@link User}>
     */
    //查询
    @Select("SELECT id, avatar, create_time, email, nickname, password, `type`, update_time, username FROM wuxiangblog.t_user;")
    List<User> queryAll();

    //    @Insert("INSERT INTO wuxiangblog.t_user (nickname, password, username) VALUES(#{nickname},#{password},#{username});")
//    //加入该注解可以保存对象后，查看对象插入id
//    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id"

    @Insert("INSERT INTO wuxiangblog.t_user (password, username) VALUES(#{password},#{username});")
    void register(User user);


    @Select(" SELECT id,avatar, create_time,email, nickname,password,`type`, update_time,username FROM wuxiangblog.t_user WHERE username = #{username}")
        //查询用户名是否存在
    User findUserByName(String username);


}
