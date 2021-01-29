package com.chris.vueblog.mapper;

import com.chris.vueblog.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author clh
 * @since 2021-01-28
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from m_user where username=#{username}")
    User findUserByName(@Param("username") String username);
}
