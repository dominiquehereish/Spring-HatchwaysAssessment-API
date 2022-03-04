package com.hatchways.assessment.rest;

import com.hatchways.assessment.service.FetchHatchwaysService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HatchwaysRestTest {

    @Autowired
    public FetchHatchwaysService fetchHatchwaysService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        assertThat(fetchHatchwaysService).isNotNull();
    }

    @Test
    public void getPing() throws Exception{
        this.mockMvc.perform(get("/api/ping")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("true")));
    }

    @Test
    public void getPostsNoTags() throws Exception{
        this.mockMvc.perform(get("/api/posts")).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("tags parameter is required")));
    }

    @Test
    public void getPostsWithTags() throws Exception{
        this.mockMvc.perform(get("/api/posts?tags=tech")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getPostsWithBadSort() throws Exception{
        this.mockMvc.perform(get("/api/posts?tags=tech&sortBy=any")).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("sortBy parameter is invalid")));
    }

    @Test
    public void getPostsWithGoodSort() throws Exception{
        this.mockMvc.perform(get("/api/posts?tags=tech&sortBy=id")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(get("/api/posts?tags=tech&sortBy=reads")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(get("/api/posts?tags=tech&sortBy=likes")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(get("/api/posts?tags=tech&sortBy=popularity")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getPostsWithBadDir() throws Exception{
        this.mockMvc.perform(get("/api/posts?tags=tech&sortBy=likes&direction=any")).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("direction parameter is invalid")));
    }

    @Test
    public void getPostsWithGoodDir() throws Exception{
        this.mockMvc.perform(get("/api/posts?tags=tech&sortBy=likes&direction=asc"))
                .andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(get("/api/posts?tags=tech&sortBy=likes&direction=desc"))
                .andDo(print()).andExpect(status().isOk());
    }
}