package com.shenxu.zuul.config;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ly
 * @date 2020/8/12 17:59
 */

@Configuration
public class ElasticsearchConfig {

    @Bean
    public RestHighLevelClient restHighLevelClient(){
        List<HttpHost> hosts = new ArrayList<>();
        hosts.add(new HttpHost("127.0.0.1", 9200, "http"));
        HttpHost[] hostsArr = hosts.toArray(new HttpHost[0]);

        RestClientBuilder builder = RestClient.builder(hostsArr);
        builder.setRequestConfigCallback(requestConfigBuilder -> {
            requestConfigBuilder.setConnectTimeout(30000);
            requestConfigBuilder.setConnectionRequestTimeout(30000);
            requestConfigBuilder.setSocketTimeout(30000);
            return requestConfigBuilder;
        });

        builder.setHttpClientConfigCallback(httpClientBuilder -> {
            httpClientBuilder.setMaxConnTotal(100);
            httpClientBuilder.setMaxConnPerRoute(100);
            return httpClientBuilder;
        });

        // 线程数设计
        builder.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
            @Override
            public HttpAsyncClientBuilder customizeHttpClient(
                    HttpAsyncClientBuilder httpClientBuilder) {
                return httpClientBuilder.setDefaultIOReactorConfig(
                        IOReactorConfig.custom()
                                .setIoThreadCount(1)
                                .build());
            }
        });

        // 设置header 避免在每个请求中都设置
        builder.setDefaultHeaders(new Header[]{new BasicHeader("header", "value")});

        // 设置监听 失败的时候及时反馈
        builder.setFailureListener(new RestClient.FailureListener(){
            @Override
            public void onFailure(Node node) {
                super.onFailure(node);
                // todo 失败通知 短信 邮件 钉钉等

            }
        });

        /*
         *设置节点选择器以用于过滤客户端将向其自身设置的请求中的客户端发送请求的节点。
         * 例如，在启用嗅探功能时，这可以防止阻止向专用主节点发送请求。
         * 默认情况下，客户端将请求发送到每个已配置的节点。
         * todo 说实话没有搞懂
         */
        builder.setNodeSelector(NodeSelector.SKIP_DEDICATED_MASTERS);

        return new RestHighLevelClient(builder);
    }

}
