package com.hatchways.assessment.service;

import com.hatchways.assessment.model.Post;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PostBuilder {

    private Post post;
    private List<String> tags = new ArrayList<>(Arrays.asList("tech","culture","health","science"));

    public PostBuilder(){
        this.post = new Post();
    }

    public Post generate(){
        post.setAuthor(makeName());
        post.setAuthorId(new Random().nextInt(10)+1);
        post.setId(new Random().nextInt(100)+1);
        post.setLikes(new Random().nextInt(500)+1);
        post.setPopularity(Math.random());
        post.setReads(new Random().nextInt(1000)+1);
        post.setTags(tags);
        return post;
    }

    public Post copyPost(Post post){
        post.setAuthor(post.getAuthor());
        post.setAuthorId(post.getAuthorId());
        post.setId(post.getId());
        post.setLikes(post.getLikes());
        post.setPopularity(post.getPopularity());
        post.setReads(post.getReads());
        post.setTags(post.getTags());
        return post;
    }

    public String makeName(){
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        String name = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return name;
    }
}

