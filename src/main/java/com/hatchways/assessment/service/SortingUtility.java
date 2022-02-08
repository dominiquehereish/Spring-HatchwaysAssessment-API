package com.hatchways.assessment.service;

import com.hatchways.assessment.model.Post;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingUtility {

    public static void sortListBy(List<Post> list, String by){
        switch(by) {
            case "id":
                Collections.sort(list, Comparator.comparing(Post::getId));
                break;
            case "likes":
                Collections.sort(list, Comparator.comparing(Post::getLikes));
                break;
            case "popularity":
                Collections.sort(list, Comparator.comparing(Post::getPopularity));
                break;
            case "reads":
                Collections.sort(list, Comparator.comparing(Post::getReads));
                break;
            default:
                break;
        }
    }

    public static void setListDirection(List<Post> list, String direction){
        if(direction.equals("desc")) {
            Collections.reverse(list);
        }
    }
}
