package com.wuxianggujun.wuxiangblog;

import com.wuxianggujun.wuxiangblog.entity.User;
import com.wuxianggujun.wuxiangblog.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//表示当前的类是一个测试类,不会随着项目一起打包
@SpringBootTest
//表示启动这个单元测试类是不能运行的，需要传递一个参数，必须是SpringRunner的实例类型
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //idea有检测功能，接口是不能够直接创建bean的（动态代理技术）
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("qwert");
        user.setEmail("1234567890");
        user.setNickname("wuxiang");
        user.setAvatar("1xaxsxdXaaxq");
        user.setPassword("123456789");
        System.out.println(userMapper.insert(user));

    }

}
