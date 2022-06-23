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

    //结果映射列表,全部字段度需要映射，不然问题太他吗麻烦了

//    /**
//     * 查询所有
//     * MyBatis面向接口编程的两个一致
//     * 1.Mapper接口与xml映射文件的namespace全类名保持一致
//     * 2.映射文件中SQL语句的id要和mapper接口中的方法一致
//     *
//     * @return {@link List}<{@link User}>
//     */
//    //查询
//    @Select("SELECT id, avatar, create_time, email, nickname, password, `type`, update_time, username FROM wuxiangblog.t_user;")
//    List<User> queryAllUsers();
//
//    // @Insert("INSERT INTO wuxiangblog.t_user (nickname, password, username) VALUES(#{nickname},#{password},#{username});")
//    // 加入该注解可以保存对象后，查看对象插入id
//    // @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id"
//    //@Insert("INSERT INTO wuxiangblog.t_user (password, username) VALUES(#{password},#{username});")
//    //@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
//    // int register(User user);
//
//    @Insert({"INSERT INTO wuxiangblog.t_user (avatar, create_time, email, nickname, password, username) VALUES(#{avatar}, #{createTime}, #{email}, #{nickname}, #{password}, #{username});"})
//    @Results(id = "datetimeMap", value = {
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })
//    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
//    int insertUser(User user);
//
//
//    @Delete("DELETE FROM wuxiangblog.t_user WHERE id=#{id};")
//    boolean deleteUserById(@Param("id") Long id);
//
//    User findUserById(@Param("id") Long id);
//
//    User findUserByUserName(@Param("username") String username);


}
