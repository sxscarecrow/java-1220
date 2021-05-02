package com.shenxu.zuul.mybatis;

import com.shenxu.zuul.repository.demo.ArticleRepository;
import com.shenxu.zuul.repository.test.UserRepository;
import com.shenxu.zuul.mapper.Demo.ArticleMapper;
import com.shenxu.zuul.mapper.Test.UserMapper;
import com.shenxu.zuul.domain.po.Test.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author ly
 * @date 2020/11/13 18:11
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class DynamicDatasource {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRepository userIservice;
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleRepository articleIservice;

    @Test
    public void test() {

        User user = new User();
        user.setName("shenxu");
        user.setAge(1);

        userMapper.insert(user);

        System.out.println(userIservice.getById(1));
    }

    @Test
    public void demo() {

    }
}
