package com.aliyun.eci.demo.http;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpClientHelper {

    private final static String SERVER_IP = "127.0.0.1";

    private final static String SERVER_PORT = "8761";

    private final static int CONNECTION_TIMEOUT = 10000;

    private final static int SOCKET_TIMEOUT = 10000;

    private final static int REQUEST_PER_MINUTE = 5;

    public static String sendPost(String urlParam) throws IOException {
        PostMethod postMethod = new PostMethod(urlParam);
        postMethod.addRequestHeader("Content-Type", "application/json");

        initClient().executeMethod(postMethod);
        String result = postMethod.getResponseBodyAsString();
        postMethod.releaseConnection();
        return result;
    }

    public static String sendGet(String urlParam) throws IOException {
        GetMethod getMethod = new GetMethod(urlParam);
        getMethod.addRequestHeader("Content-Type", "application/json");

        initClient().executeMethod(getMethod);
        String result = getMethod.getResponseBodyAsString();
        getMethod.releaseConnection();
        return result;
    }


    private static HttpClient initClient() {
        HttpClient httpClient = new HttpClient();
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(CONNECTION_TIMEOUT);
        httpClient.getHttpConnectionManager().getParams().setSoTimeout(SOCKET_TIMEOUT);
        return httpClient;
    }

    public static void main(String[] args) throws InterruptedException {
        String url = String.format("http://%s:%s/hello", SERVER_IP, SERVER_PORT);

        while (true) {
            new Thread(() -> {
                try {
                    System.out.println(sendGet(url));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            Thread.sleep(60000 / REQUEST_PER_MINUTE);
        }
    }
}