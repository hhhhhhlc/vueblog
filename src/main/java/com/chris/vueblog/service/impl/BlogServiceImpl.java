package com.chris.vueblog.service.impl;

import com.chris.vueblog.entity.Blog;
import com.chris.vueblog.mapper.BlogMapper;
import com.chris.vueblog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author clh
 * @since 2021-01-28
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
