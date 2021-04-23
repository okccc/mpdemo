package com.okccc.mpdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.okccc.mpdemo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Author: okccc
 * Date: 2021/4/21 下午2:08
 * Desc: 读写数据库的通用Mapper
 */

@Repository
public interface UserMapper extends BaseMapper<User> {
}
