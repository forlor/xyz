package org.xyz.es;

import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.StringQuery;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EsStart
 * @Description TODO
 * @Author xyz
 * @Date 2020/5/25 11:09
 * @Version 1.0
 **/
@SpringBootApplication
public class EsStart{
@Autowired
private RestClient restClient;
    @Autowired
    private RestHighLevelClient client;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public static void main(String[] args) {
       SpringApplication.run(EsStart.class, args);

    }


    public void run(String... args) throws Exception {
        String json = "{\n" +
                "  \n" +
                "  \"query\": {\n" +
                "    \"bool\": {\n" +
                "      \"must\": [\n" +
                "        {\"term\": {\n" +
                "          \"MessageHeader.METype.keyword\": {\n" +
                "            \"value\": \"JAPP\"\n" +
                "          }\n" +
                "        }},{\n" +
                "          \"range\": {\n" +
                "            \"MessageBody.callTime.keyword\": {\n" +
                "              \"gte\": \"2020-05-21 15:11:16\",\n" +
                "              \"lte\": \"2020-05-21 15:52:30\"\n" +
                "            }\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  }, \"aggs\": {\n" +
                "    \"groupMEID\": {\n" +
                "      \"terms\": {\n" +
                "        \"field\": \"MessageHeader.METype.keyword\"\n" +
                "        \n" +
                "      }\n" +
                "    }\n" +
                "  },\"sort\": [\n" +
                "    {\n" +
                "      \"MessageBody.duration\": {\n" +
                "        \"order\": \"desc\"\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "  \n" +
                "}";
        Request request = new Request("GET","xyz_test/_search");
        request.setJsonEntity(json);
        Response response = restClient.performRequest(request);
        InputStream content = response.getEntity().getContent();
        InputStreamReader isr = new InputStreamReader(content);
        BufferedReader bufferedReader = new BufferedReader(isr);
        while (bufferedReader.ready()){
            System.out.println(bufferedReader.readLine());
        }
     //   System.out.println(response);
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        URI uri = new URIBuilder("http://www.baidu.com/s").set
//
//
//                .setParameter("wd", "java").build();
    }
}

