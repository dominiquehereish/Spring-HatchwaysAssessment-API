package com.hatchways.assessment.service.impl;

import org.junit.jupiter.api.Test;
import com.hatchways.assessment.service.FetchHatchwaysService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class FetchHatchwaysServiceImplTest {

    @Autowired
    public FetchHatchwaysService fetchHatchwaysService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPositivePing() {
    }

    @Test
    public void getNegativePing() {
    }

    @Test
    public void getPosts() {
    }


    @Test
    public void testGetPosts() {
    }
}