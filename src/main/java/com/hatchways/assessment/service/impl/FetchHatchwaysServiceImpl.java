package com.hatchways.assessment.service.impl;

import com.hatchways.assessment.rest.response.PingResponse;
import com.hatchways.assessment.rest.response.PostsResponse;
import com.hatchways.assessment.service.FetchHatchwaysService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class FetchHatchwaysServiceImpl implements FetchHatchwaysService {

    final String HATCHWAYS_URL_API = "https://api.hatchways.io/assessment/blog/posts";

    @Override
    public PostsResponse getPosts(String tag, String sortBy, String direction) {
        return null;
    }

    @Override
    public PingResponse getPing() {
        PingResponse pingResponse = new PingResponse();
        CloseableHttpResponse response = performGetRequest("\"\"");
        pingResponse.setSuccess(response.getStatusLine().getStatusCode());
        return pingResponse;
    }

    private CloseableHttpResponse performGetRequest(String params) {
        try {
            HttpGet request = new HttpGet(HATCHWAYS_URL_API);
            URI uri = new URIBuilder(request.getURI()).addParameter("tag", params).build();
            request.setURI(uri);
            CloseableHttpClient client = HttpClients.createDefault();
            return client.execute(request);
        } catch (URISyntaxException e) {
        } catch (IOException e){
        }
        return null;
    }
}
