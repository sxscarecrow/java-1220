package com.shenxu.zuul.mapper.Demo;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shenxu.zuul.domain.po.Demo.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ly
 */
@Mapper
@DS("demo")
public interface ArticleMapper extends BaseMapper<Article> {
}
