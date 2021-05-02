package com.shenxu.zuul.elasticsearch;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ly
 * @date 2020/8/19 19:25
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class CreateIndex {

    @Qualifier("restHighLevelClient")
    @Autowired
    private RestHighLevelClient client;

    /**
     * 创建索引并添加映射关系
     *
     * @throws IOException
     */
    @Test
    public void createIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("yangmanxiang_test");

        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        {
            builder.startObject("properties");
            {
                builder.startObject("message");
                {
                    builder.field("type", "text");
                }
                builder.endObject();
            }
            builder.endObject();
        }
        builder.endObject();

        request.mapping(builder);

        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);

        boolean flag = response.isAcknowledged();

        System.out.println(flag);

        System.out.println(response.toString());
    }

    /**
     * 获取索引
     *
     * @throws IOException
     */
    @Test
    public void get() throws IOException {
        GetIndexRequest request = new GetIndexRequest("yangmanxiang");

        GetIndexResponse response = client.indices().get(request, RequestOptions.DEFAULT);

        System.out.println(response.getIndices().toString());
        System.out.println(response.getMappings());
    }

    /**
     * 数据插入
     *
     * @throws IOException
     */
    @Test
    public void insert() throws IOException {
        IndexRequest request = new IndexRequest("yangmanxiang_test");

        Map<String, String> map = new HashMap<>();
        map.put("message", "This is a beautiful girl!");

        request.source(map);

        IndexResponse response = client.index(request, RequestOptions.DEFAULT);

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("response.getResult() ------------" + response.getResult());
        System.out.println("response.status()" + response.status());
        System.out.println("response.getResult()" + response.toString());
        System.out.println("-------------------------------------------------------------------------");

    }

    /**
     * 更新文档
     *
     * @throws IOException
     */
    @Test
    public void update() throws IOException {

        Map<String, Integer> map = new HashMap<>();
//        map.put("message", "This is a beautiful body!");
        map.put("age", 22);

        UpdateRequest request = new UpdateRequest("yangmanxiang_test", "dtsWT3UBqBfK7fDqGMZ_");
        request.script(new Script("ctx._source.age+=1"));
//        request.doc("message", "This is a beautiful body!");

        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("response.getResult() ------------" + response.getResult());
        System.out.println("response.status()" + response.status());
        System.out.println("response.getResult()" + response.toString());
        System.out.println("-------------------------------------------------------------------------");

    }

    /**
     * 删除文档
     *
     * @throws IOException
     */
    @Test
    public void delete() throws IOException {
        DeleteRequest request = new DeleteRequest("yangmanxiang_test", "ddsVT3UBqBfK7fDqV8Yh");

        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("response.getResult() ------------" + response.getResult());
        System.out.println("response.status()" + response.status());
        System.out.println("response.getResult()" + response.toString());
        System.out.println("-------------------------------------------------------------------------");

    }

    /**
     * 获取文档
     *
     * @throws IOException
     */
    @Test
    public void getDoc() throws IOException {
        GetRequest request = new GetRequest("yangmanxiang_test", "dtsWT3UBqBfK7fDqGMZ_");

        GetResponse response = client.get(request, RequestOptions.DEFAULT);

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("response.getSource()" + response.getSource());
        System.out.println(response.toString());

        System.out.println("-------------------------------------------------------------------------------");
    }

}
