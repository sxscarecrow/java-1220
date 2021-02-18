package com.shenxu.zuul.filter.servlet;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * 过滤器 测试执行顺序
 *
 * @author shen_xu
 * @ClassName DemoFilter
 */

/*
*  @Order(4)
*  这个注解并不会生效 如果想改变其执行顺序 需要写配置类用于控制 具体见 FilterConfig.class 默认的执行顺序是 filterName 的 字母升序执行
*
*  initParams = @WebInitParam(name = "hh", value = "hello") 初始化参数 可以 在 init() 用 filterConfig 获取
 */

@WebFilter(urlPatterns = "/*", filterName = "demoFilter", initParams = @WebInitParam(name = "hh", value = "hello"))
public class DemoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 自定义逻辑
        System.out.println("测试一下过滤器的执行顺序: 这是第二个执行的过滤器");

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getInitParameter("hh"));
    }

    @Override
    public void destroy() {

    }
}
