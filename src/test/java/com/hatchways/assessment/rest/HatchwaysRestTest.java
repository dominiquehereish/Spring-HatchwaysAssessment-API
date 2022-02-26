package com.hatchways.assessment.rest;

import com.hatchways.assessment.service.FetchHatchwaysService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HatchwaysRestTest {

    @Autowired
    public FetchHatchwaysService fetchHatchwaysService;

    @Test
    public void contextLoads() throws Exception {
        assertThat(fetchHatchwaysService).isNotNull();
    }

//    @Test
//    public void getPosts() {
//    }
}