package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.TBlog;
import generator.service.TBlogService;
import generator.mapper.TBlogMapper;
import org.springframework.stereotype.Service;

/**
* @author MI
* @description 针对表【t_blog】的数据库操作Service实现
* @createDate 2022-06-25 17:19:46
*/
@Service
public class TBlogServiceImpl extends ServiceImpl<TBlogMapper, TBlog>
    implements TBlogService{

}




