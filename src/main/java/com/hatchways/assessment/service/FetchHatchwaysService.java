package com.hatchways.assessment.service;

import com.hatchways.assessment.rest.response.PingResponse;
import com.hatchways.assessment.rest.response.PostsResponse;

public interface FetchHatchwaysService {

    public PostsResponse getPosts(String tag, String sortBy, String direction);
    public PingResponse getPing();

}
