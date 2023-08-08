package cn.hy.chatbot.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @description:
 * @author：hy
 * @date: 2023/8/3
 */
public class ApiTest {

    @Test
    public void queryQuestion() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");
        httpGet.addHeader("cookie", "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22186f9e0263871b-0577d15d7afa738-7a545475-1327104-186f9e02639793%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2ZjllMDI2Mzg3MWItMDU3N2QxNWQ3YWZhNzM4LTdhNTQ1NDc1LTEzMjcxMDQtMTg2ZjllMDI2Mzk3OTMifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%22186f9e0263871b-0577d15d7afa738-7a545475-1327104-186f9e02639793%22%7D; zsxq_access_token=A1EF371C-793A-F6F0-3CE2-456652C967A6_1012D97D97F2B74D;");
        httpGet.addHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(httpGet);

        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String responeStr = EntityUtils.toString(response.getEntity());
            System.out.println(responeStr);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("https://api.zsxq.com/v2/topics/411885114818218/comments");

        httpPost.addHeader("cookie", "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22186f9e0263871b-0577d15d7afa738-7a545475-1327104-186f9e02639793%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2ZjllMDI2Mzg3MWItMDU3N2QxNWQ3YWZhNzM4LTdhNTQ1NDc1LTEzMjcxMDQtMTg2ZjllMDI2Mzk3OTMifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%22186f9e0263871b-0577d15d7afa738-7a545475-1327104-186f9e02639793%22%7D; zsxq_access_token=A1EF371C-793A-F6F0-3CE2-456652C967A6_1012D97D97F2B74D;");
        httpPost.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"你好嘛\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        httpPost.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(httpPost);

        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String responeStr = EntityUtils.toString(response.getEntity());
            System.out.println(responeStr);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

}
