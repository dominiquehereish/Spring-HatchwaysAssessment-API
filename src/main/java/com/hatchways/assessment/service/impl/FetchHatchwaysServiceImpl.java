package com.hatchways.assessment.service.impl;

import com.google.gson.Gson;
import com.hatchways.assessment.model.Post;
import com.hatchways.assessment.rest.response.PingResponse;
import com.hatchways.assessment.rest.response.PostsResponse;
import com.hatchways.assessment.service.FetchHatchwaysService;
import com.hatchways.assessment.service.SortingUtility;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FetchHatchwaysServiceImpl implements FetchHatchwaysService {

    final String HATCHWAYS_URL_API = "https://api.hatchways.io/assessment/blog/posts";

    @Override
    public PostsResponse getPosts(String tags, String sortBy, String direction) {
        List<String> tagList = Arrays.asList(tags.split(","));
        List<Post> postsList = new ArrayList<Post>();
        for (String tag : tagList){
            List<Post> resList = getPosts(tag);
            for(Post post : resList){
                postsList.add(post);
            }
        }
        postsList = SortingUtility.removeDups(postsList);
        SortingUtility.sortListBy(postsList, sortBy);
        SortingUtility.setListDirection(postsList, direction);

        PostsResponse responsePosts = new PostsResponse();
        responsePosts.setPosts(postsList);
        return responsePosts;
    }

    @Override
    public PingResponse getPing() {
        PingResponse pingResponse = new PingResponse();
        CloseableHttpResponse response = performGetRequest("\"\"");
        pingResponse.setSuccess(response.getStatusLine().getStatusCode());
        return pingResponse;
    }

    public List<Post> getPosts(String tag) {
        CloseableHttpResponse response = performGetRequest(tag);
        HttpEntity entity = response.getEntity();
        String result = null;
        try {
            result = EntityUtils.toString(entity);
        } catch (IOException e) {
        }
        PostsResponse postsResponse = new Gson().fromJson(result, PostsResponse.class);
        return postsResponse.getPosts();
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
