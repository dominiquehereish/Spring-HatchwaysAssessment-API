package com.hatchways.assessment.rest.response;

import com.hatchways.assessment.model.Post;

import java.util.List;

public class PostsResponse extends Response{

    private List<Post> posts;

    public List<Post> getPosts(){return posts;}

    public void setPosts(List<Post> list){
        this.posts = list;
    }
}
