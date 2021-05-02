package com.shenxu.zuul.repository.demo;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shenxu.zuul.mapper.Demo.ArticleMapper;
import com.shenxu.zuul.domain.po.Demo.Article;


/**
 * @author ly
 */
@DS("demo")
public class ArticleRepository extends ServiceImpl<ArticleMapper, Article> {
}
