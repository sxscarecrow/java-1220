package com.shenxu.zuul.filter.servlet;

import com.shenxu.zuul.util.StrUtil;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 过滤器
 *
 * @author shen_xu
 * @ClassName TestFilter
 */

@WebFilter(urlPatterns = "/*", filterName = "testFilter")
public class TestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // todo 自定义的逻辑代码
        System.out.println("测试一下顺序：这是第一个过滤器");

        long start = System.currentTimeMillis();
        System.out.println("Execute cost=" + (System.currentTimeMillis() - start));

        MDC.put("requestId", StrUtil.uuid());

        // 过滤链路
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {
        MDC.remove("requestId");
    }
}
