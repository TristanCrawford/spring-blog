package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String getIndex() {
        return "Posts Index";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String getPost(@PathVariable int id) {
        return "Post " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String getCreate() {
        return "Create - GET";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreate() {
        return "Create - POST";
    }
}