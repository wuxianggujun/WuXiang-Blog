package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.TUser;
import generator.service.TUserService;
import generator.mapper.TUserMapper;
import org.springframework.stereotype.Service;

/**
* @author MI
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-06-23 09:01:39
*/
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser>
    implements TUserService{

}




