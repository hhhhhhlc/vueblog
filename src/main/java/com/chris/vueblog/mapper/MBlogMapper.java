package com.chris.vueblog.mapper;

import com.chris.vueblog.model.MBlog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MBlogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_blog
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_blog
     *
     * @mbggenerated
     */
    int insert(MBlog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_blog
     *
     * @mbggenerated
     */
    MBlog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_blog
     *
     * @mbggenerated
     */
    List<MBlog> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_blog
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MBlog record);
}