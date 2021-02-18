package com.shenxu.zuul.elasticsearch;

import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequest;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.TermVectorsRequest;
import org.elasticsearch.client.core.TermVectorsResponse;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.VersionType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.elasticsearch.search.suggest.term.TermSuggestion;
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
 * @date 2020/8/12 18:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class test {

    @Qualifier("restHighLevelClient")
    @Autowired
    private RestHighLevelClient client;

    @Test
    public void createIndex() throws IOException {
        /*
         * 一.创建索引
         *  方式1：
         *
         *
         */
        IndexRequest request = new IndexRequest("shenxu", "docs", "2");
        String jsonString =  "{" +
                "\"user\":\"shenxu\"," +
                "\"postDate\":\"2020-01-30\"," +
                "\"message\":\"我就试试\"" +
                "}";
        request.source(jsonString, XContentType.JSON);

        // 同步响应
        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
        if (indexResponse.getResult() == DocWriteResponse.Result.CREATED){
            System.out.println("同步响应，索引创建创建成功");
        }

//        XContentBuilder builder = XContentFactory.jsonBuilder();
//        builder.startObject();
//        {
//            builder.field("user", "kimchy");
////        builder.timeField("postDate", new Date());
//            builder.field("message", "trying out Elasticsearch");
//        }
//        builder.endObject();
//
//
//        CreateIndexRequest createIndexRequest = new CreateIndexRequest("test2");
////        createIndexRequest.source(jsonString, XContentType.JSON);
//        createIndexRequest.mapping(builder);
//        CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
//        System.out.println(createIndexResponse.isAcknowledged());

        // 异步响应
//        client.indexAsync(request, RequestOptions.DEFAULT, new ActionListener<IndexResponse>() {
//            @Override
//            public void onResponse(IndexResponse indexResponse) {
//                if (indexResponse.getResult() == DocWriteResponse.Result.CREATED){
//                    System.out.println("异步响应，索引创建创建成功");
//                }
//            }
//            @Override
//            public void onFailure(Exception e) {
//                System.out.println("索引创建创建失败，错误信息为：" + e.getMessage());
//            }
//        });

    }

    /**
     * 获取索引
     * @throws IOException
     */
    @Test
    public void getIndex() throws IOException{
        GetRequest getRequest = new GetRequest("shenxu", "1");
//        getRequest.fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE);
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(getResponse.getSource());
    }

    /**
     * 判断索引是否存在
     * @throws IOException
     */
    @Test
    public void existIndex() throws IOException {
        GetRequest getRequest = new GetRequest("shenxu", "1");
        getRequest.fetchSourceContext(new FetchSourceContext(false)); // 禁用提取_source
        getRequest.storedFields("_none_"); // 禁用获取存储的字段

        // 同步执行
        boolean flag = client.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println("该索引是否存在：" + flag);

        // 异步执行 目前版本存在问题
        client.existsAsync(getRequest, RequestOptions.DEFAULT, new ActionListener<Boolean>() {
            @Override
            public void onResponse(Boolean aBoolean) {
                System.out.println("true");
            }

            @Override
            public void onFailure(Exception e) {
                System.out.println("false");
            }
        });
    }

    /**
     * 删除索引
     * @throws IOException
     */
    @Test
    public void deleteIndex() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("shenxu", "2");
        DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);

        if (deleteResponse.getResult() == DocWriteResponse.Result.DELETED){
            System.out.println("删除成功");
        }
        System.out.println("======================================");
        System.out.println(deleteResponse.toString());
        System.out.println("======================================");
    }

    @Test
    public void updateIndex() throws IOException {
        /*
         * 方式一
         */
//        UpdateRequest updateRequest = new UpdateRequest("shenxu", "1");
//        String jsonString = "{" +
//                "\"updated\":\"2017-01-01\"," +
//                "\"reason\":\"daily update\"" +
//                "}";
//        updateRequest.doc(jsonString, XContentType.JSON);
//        UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
//        if (updateResponse.getResult() == DocWriteResponse.Result.UPDATED){
//            System.out.println("更新成功");
//        }
//        System.out.println("======================================");
//        System.out.println(updateResponse.toString());
//        System.out.println("======================================");

        /*
         * 方式二
         */
//        for (int i = 2000; i < 3000; i++){
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("user", "shenxu");
            jsonMap.put("reason", "you know, i am very fan sometime");
            jsonMap.put("message", "我就走走" + "user");

            UpdateRequest updateRequest = new UpdateRequest("shenxu", "docs", "2")
                    .routing("user")
                    .doc(jsonMap);

            UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
            if (updateResponse.getResult() == DocWriteResponse.Result.UPDATED){
                System.out.println("更新成功");
            }
            System.out.println("================" + "user" + "======================");
            System.out.println(updateResponse.toString());
            System.out.println("======================================");
//        }


        // 查询
        GetRequest getRequest = new GetRequest("shenxu", "docs", "2");
//        getRequest.realtime(false);
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(getResponse.getSource());

    }

    /**
     * 说实话真的没有怎么搞懂
     * @throws IOException
     */
    @Test
    public void termIndex() throws IOException {

        TermVectorsRequest termVectorsRequest = new TermVectorsRequest("person", "1");
//        termVectorsRequest.setFields("name");

        TermVectorsResponse termVectorsResponse = client.termvectors(termVectorsRequest, RequestOptions.DEFAULT);

        System.out.println(termVectorsResponse);
    }

    /**
     * 批量执行请求
     * @throws IOException
     */
    @Test
    public void bulkRequest() throws IOException {
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest("post")
                .id("1")
                .source(XContentType.JSON, "filed", "foo"));
        request.add(new IndexRequest("posts")
                .id("3")
                .source(XContentType.JSON, "filed", "bar"));
        request.add(new DeleteRequest("posts").id("2"));

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "shenxu");
        jsonMap.put("reason", "you know, i am very fan sometime");
        request.add(new UpdateRequest("posts", "id").doc(jsonMap));

        request.add(new DeleteRequest("shenxu", "docs", "1"));


        BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);

        for(BulkItemResponse bulkItemResponse : bulkResponse){

            DocWriteResponse docWriteResponse = bulkItemResponse.getResponse();
            
            switch (docWriteResponse.getResult()){
                case DELETED:
                    DeleteResponse deleteResponse = (DeleteResponse) docWriteResponse;
                    System.out.println("deleteResponse" + deleteResponse.toString());
                    break;
                case CREATED:
                    IndexResponse indexResponse = (IndexResponse) docWriteResponse;
                    System.out.println("indexResponse" + indexResponse.toString());
                    break;
                case UPDATED:
                    UpdateResponse updateResponse = (UpdateResponse) docWriteResponse;
                    System.out.println("updateResponse" + updateResponse.toString());
                    break;
            }

        }
    }

    /**
     * 我的理解就是分词器的意思 看这个分词到底是怎么样的
     * @throws IOException
     */
    @Test
    public void analyze() throws IOException {

//        MultiGetRequest multiGetRequest = new MultiGetRequest();
//        multiGetRequest.add(new MultiGetRequest.Item("index", "6"));


        AnalyzeRequest request = new AnalyzeRequest();
        request.text("Some text to analyze", "Some more text to analyze");
        request.analyzer("english");

        AnalyzeResponse response = client.indices().analyze(request, RequestOptions.DEFAULT);

        System.out.println(response);

    }

    @Test
    public void search() throws IOException {

        SearchRequest request = new SearchRequest("shenxu");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("s", "sh");

        sourceBuilder.query(termQueryBuilder);
        request.source(sourceBuilder);

        client.search(request, RequestOptions.DEFAULT);


        BoolQueryBuilder queryBuilder = new BoolQueryBuilder();

        queryBuilder.should(
                QueryBuilders.nestedQuery("shenxu", QueryBuilders.matchPhraseQuery("shenxu.name", "ll"), ScoreMode.None));




    }
}
