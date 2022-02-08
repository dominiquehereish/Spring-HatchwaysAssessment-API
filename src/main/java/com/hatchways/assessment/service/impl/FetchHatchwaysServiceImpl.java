package com.hatchways.assessment.service.impl;

import com.hatchways.assessment.rest.response.PingResponse;
import com.hatchways.assessment.rest.response.PostsResponse;
import com.hatchways.assessment.service.FetchHatchwaysService;
import org.springframework.stereotype.Service;

@Service
public class FetchHatchwaysServiceImpl implements FetchHatchwaysService {
    @Override
    public PostsResponse getPosts(String tag, String sortBy, String direction) {
        return null;
    }

    @Override
    public PingResponse getPing() {
        return null;
    }
}
