package com.shenxu.zuul.filter.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

/**
 * @author ly
 * @date 2020/8/3 19:03
 */

@Component
public class PreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        /*-------------------------------------------------------------------------------------
         * 这里总共有四种类型
         * 1.pre ->这种过滤器在请求被路由之前调用。可利用这种过滤器实现身份验证、在集群中选择请求的微服务，记录调试信息等。
         * 2.routing -> 这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用apache httpclient或netflix ribbon请求微服务。
         * 3.post -> 这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的http header、收集统计信息和指标、将响应从微服务发送给客户端等。
         * 4.error -> 在其他阶段发送错误时执行该过滤器
         * 5.还可以自定义过滤器
         * 6.感觉也可以根据具体的业务逻辑来返回对应的类型
         *-------------------------------------------------------------------------------------*/
        return "PRE_TYPE";
    }

    @Override
    public int filterOrder() {
        /*--------------------------------------------------------------------------------------
         * 1.filter的执行顺序，数值越小执行顺序排名越前
         * 2.这里也是可以根据具体的业务来生成具体的顺序
         *
         *------------------------------------------------------------------------------------*/
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        /*-------------------------------------------------------------------------------------
        * 1.false时默认不执行
        * 2.true执行
        * 3.这里也可以获取请求进来的相关信息进行逻辑操作，根据具体的业务确定最终是否需要进行进行过滤功能
        *
        *-------------------------------------------------------------------------------------*/
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        /*-------------------------------------------------------------------------------------
         * 这里来写具体的过滤逻辑
         *-------------------------------------------------------------------------------------*/
        return null;
    }
}
