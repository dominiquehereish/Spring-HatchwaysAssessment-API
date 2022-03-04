package com.hatchways.assessment.service;

import com.hatchways.assessment.model.Post;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SortingUtilityTest {


    private Post post1 = new PostBuilder().generate();
    private Post post2 = new PostBuilder().generate();
    private Post post3 = new PostBuilder().generate();
    private List<Post> postList = new ArrayList<>(Arrays.asList(post1, post2, post3));

    @Test
    void removeDups() {
        postList.add(new PostBuilder().copyPost(post1));
        postList.add(new PostBuilder().copyPost(post2));
        SortingUtility.removeDups(postList);
        List<Long> id = new ArrayList<>();
        for(Post post : postList){
            id.add(post.getId());
        }
        Set<Long> postSet = new HashSet<Long>(id);
        assertThat(postList.size() == postSet.size());

    }

    @Test
    void sortListBy() {
        SortingUtility.sortListBy(postList, "id");
        assertThat(postList.get(0).getId() < postList.get(1).getId() &&
                postList.get(1).getId() < postList.get(2).getId());
        SortingUtility.sortListBy(postList, "reads");
        assertThat(postList.get(0).getReads() < postList.get(1).getReads() &&
                postList.get(1).getReads() < postList.get(2).getReads());
        SortingUtility.sortListBy(postList, "likes");
        assertThat(postList.get(0).getLikes() < postList.get(1).getLikes() &&
                postList.get(1).getLikes() < postList.get(2).getLikes());
        SortingUtility.sortListBy(postList, "popularity");
        assertThat(postList.get(0).getPopularity() < postList.get(1).getPopularity() &&
                postList.get(1).getPopularity() < postList.get(2).getPopularity());

    }

    @Test
    void setListDirection() {
        //SortingUtility.sortListBy(postList, "id");
        SortingUtility.setListDirection(postList,"desc");
        assertThat(postList.get(0).getId() > postList.get(1).getId() &&
                postList.get(1).getId() > postList.get(2).getId());
    }

}