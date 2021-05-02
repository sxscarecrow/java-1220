package com.shenxu.zuul.mapper.Test;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shenxu.zuul.domain.po.Test.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ly
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
