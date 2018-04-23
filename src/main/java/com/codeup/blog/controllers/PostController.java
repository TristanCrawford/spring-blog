package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.services.UserService;
import com.codeup.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostService postService;
    private final UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        try {
            model.addAttribute("post", postService.getPost(id));
        } catch (IndexOutOfBoundsException e) {
            model.addAttribute("post", new Post("Uh Oh...", "Looks like you tried to access an invalid posting!", null));
        }
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String getEdit(@PathVariable long id, Model model) {
        model.addAttribute("post", postService.getPost(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String postEdit(@PathVariable long id, @ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/posts/{id}";
    }

    @GetMapping("/posts/create")
    public String getCreate(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postCreate(@ModelAttribute Post post) {
        post.setAuthor(userService.getUser(1));
        postService.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String postDelete(@PathVariable long id) {
        postService.delete(id);
        return "redirect:/posts";
    }
}
