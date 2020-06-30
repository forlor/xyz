package org.xyz.springmvc.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.xyz.springmvc.service.IndexService;

@SpringBootTest
class IndexControllerTest {

    private MockMvc mvc;
    @Autowired
    private IndexService indexService;
    @BeforeEach
    public void setUp(){
         mvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();

    }
    @Test
    public void test1(){

        System.out.println(indexService.getUUID());
    }

    @Test
    void index() {
    }

    @Test
    void success() {
    }
}