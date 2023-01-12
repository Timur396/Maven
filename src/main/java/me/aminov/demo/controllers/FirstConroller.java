package me.aminov.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstConroller {

   @GetMapping
    public String helloWorld() {
        return "";
    }

    @GetMapping("/info")
    public String helloWorld(@RequestParam String page) {
        return "Hello,ret"+page;
    }

}
