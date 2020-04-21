package com.epam.demo.breakfastpetproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping(path = "hello", params = "name")
    public String helloUsername(@RequestParam("name") String name) {
        return "Hello, " + name + "!";
    }

}