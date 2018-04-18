package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    private List<Post> posts = Arrays.asList(
            new Post("Post A", "This is the body of post A"),
            new Post("Post B", "This is the body of post B"),
            new Post("Post C", "This is the body of post C"),
            new Post("Post D", "This is the body of post D"),
            new Post("Post E", "This is the body of post E"),
            new Post("Post F", "This is the body of post F")
    );

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable int id, Model model) {
        try {
            model.addAttribute("post", posts.get(id));
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
