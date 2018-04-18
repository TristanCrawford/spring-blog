package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable int id, Model model) {
        try {
            model.addAttribute("post",  postService.getPost(id));
        } catch (IndexOutOfBoundsException e) {
            model.addAttribute("post", new Post("Uh Oh...", "Looks like you tried to access an invalid posting!"));
        }
        return "posts/show";
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
