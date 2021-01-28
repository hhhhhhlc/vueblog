package com.chris.vueblog.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chris.vueblog.entity.Blog;
import com.chris.vueblog.service.BlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.chris.vueblog.common.Result;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author clh
 * @since 2021-01-28
 */
@RestController
@RequestMapping("/test")
public class BlogController {
    @Autowired
    BlogService blogService;

    // 查询所有的
    @GetMapping("/blogs")
    public Result getBlogs(long currentPage) {
        Page page = new Page(currentPage, 5);
        IPage ipage = blogService.page(page);
        return Result.succ(ipage);
    }

    // 查询某一个博客的详情
    @GetMapping("/blog/{id}")
    public Result getBlogById(@PathVariable("id") long id) {
        Blog blog = blogService.getById(id);
        return Result.succ(blog);
    }

    // 新增一篇博客
    @PostMapping("/blog/edit")
    public Result addBlog(@RequestBody Blog blog) {
        Blog tempBlog = null;
        if(blog.getId() != null) {
            // 如果id不为空，则是编辑之前的文章
            // 查找出之前的文章，更新后保存
            tempBlog = blogService.getById(blog.getId());
        } else {
            // 如果id为空，那么就是新增的一篇博客
            tempBlog = new Blog();
            tempBlog.setCreated(LocalDateTime.now());
            tempBlog.setStatus(0);
            //tempBlog.setUserId();
        }

        BeanUtils.copyProperties(blog, tempBlog, "id", "userId", "created", "status");
        blogService.saveOrUpdate(tempBlog);
        return Result.succ(null);
    }
}
