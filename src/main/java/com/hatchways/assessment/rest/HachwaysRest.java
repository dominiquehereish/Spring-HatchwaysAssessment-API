package com.hatchways.assessment.rest;

import com.hatchways.assessment.rest.response.ErrorResponse;
import com.hatchways.assessment.rest.response.PingResponse;
import com.hatchways.assessment.rest.response.PostsResponse;
import com.hatchways.assessment.rest.response.Response;
import com.hatchways.assessment.rest.values.DirectionValues;
import com.hatchways.assessment.rest.values.SortByValues;
import com.hatchways.assessment.service.FetchHatchwaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HachwaysRest {

    @Autowired
    FetchHatchwaysService fetchHatchwaysService;

    @GetMapping("/ping")
    public ResponseEntity<Response> getPing() {
        PingResponse responsePing = fetchHatchwaysService.getPing();
        return ResponseEntity.ok().body(responsePing);
    }

    @GetMapping("/posts")
    public ResponseEntity<Response> getPosts(@RequestParam(required = true) String tags,
                                            @RequestParam(defaultValue = "id") String sortBy,
                                            @RequestParam(defaultValue = "asc") String direction){

        if(SortByValues.fromString(sortBy.toUpperCase()) == null)
        {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setError("sortBy parameter is invalid");
            return ResponseEntity.badRequest().body(errorResponse);
        }else if(DirectionValues.fromString(direction) == null){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setError("direction parameter is invalid");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        PostsResponse postsResponse = fetchHatchwaysService.getPosts(tags, sortBy, direction);
        return ResponseEntity.ok().body(postsResponse);
    }
}
