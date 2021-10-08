package com.epam.demo.breakfastpetproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    MockMvc mvc;



    @Test
    void testHello() throws Exception {

        mvc.perform(
                get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));

    }


    @Test
    void testHelloUsername() throws Exception {
        testHelloWithName("Johnny Silverhand");
        testHelloWithName("Honey Bun");
    }

    private void testHelloWithName(final String name) throws Exception {
        mvc.perform(
                get("/hello")
                        .param("name", name))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, " + name + "!"));
    }


}