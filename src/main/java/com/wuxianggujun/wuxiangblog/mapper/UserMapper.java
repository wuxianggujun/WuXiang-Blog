package com.wuxianggujun.wuxiangblog.mapper;

import com.wuxianggujun.wuxiangblog.entity.User;
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

    /**
     * 插入用户的数据
     *
     * @param user 用户
     * @return int 受影响的行数
     */
    int add(User user);

    //    @Insert("INSERT INTO wuxiangblog.t_user (nickname, password, username) VALUES(#{nickname},#{password},#{username});")
//    //加入该注解可以保存对象后，查看对象插入id
//    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void register(User user);

    /**
     * 按名称查询
     *
     * @param name 名字
     * @return {@link User}
     */
    User queryByName(String name);

    //查询用户名是否存在
    User findUserByName(String username);


}
