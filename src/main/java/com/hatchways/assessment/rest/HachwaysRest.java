package com.hatchways.assessment.rest;

import com.hatchways.assessment.rest.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HachwaysRest {

    @GetMapping("/ping")
    public ResponseEntity<Response> getPing() {
        return null;
    }

    @GetMapping("/posts")
    public ResponseEntity<Response> getPosts(@RequestParam(required = true) String tags,
                                            @RequestParam(defaultValue = "id") String sortBy,
                                            @RequestParam(defaultValue = "asc") String direction){
        return null;
    }
}
