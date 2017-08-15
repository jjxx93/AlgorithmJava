package httpClient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 使用HttpClient进行Get操作
 *
 * Created by xiongjiaxin on 2017/8/15.
 */
public class GetMethod {
    /**
     * 生成URI
     *
     * @param host 请求HOST
     * @param path 请求地址
     * @param parameterMap 参数表
     * @return uri
     */
    public static URI generateUri(String host, String path, Map<String, String> parameterMap)
        throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http");
        uriBuilder.setHost(host);
        uriBuilder.setPath(path);

        if (parameterMap != null && parameterMap.size() > 0) {
            List<NameValuePair> nameValuePairList = new ArrayList<>(parameterMap.size()) ;
            Set<Map.Entry<String, String>> parameterSet = parameterMap.entrySet();
            for (Map.Entry<String, String> parameter : parameterSet) {
                nameValuePairList.add(new BasicNameValuePair(parameter.getKey(), parameter.getValue()));
            }
            uriBuilder.setParameters(nameValuePairList);
        }

        return uriBuilder.build();
    }

    /**
     * Get请求json数据
     *
     * @param uri
     * @return
     */
    public String getJsonString(URI uri) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;

        try {
            HttpGet httpGet = new HttpGet(uri);
            response = httpClient.execute(httpGet);
            System.out.println(response.getStatusLine());
            HttpEntity entity1 = response.getEntity();

            if (entity1 != null) {
                long len = entity1.getContentLength();
                return len != -1 ? EntityUtils.toString(entity1) : null;
            }

            return null;
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }
}
