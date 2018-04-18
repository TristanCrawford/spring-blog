package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    private List<Post> posts;

    public PostService() {
        posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> getAllPosts() {
        return posts;
    }

    public Post getPost(long id) {
        return posts.get((int) id);
    }

    public void save(Post post) {
        post.setId((long) posts.size());
        posts.add(post);
    }

    public void edit(long id, Post post) {
        posts.get((int) id).setTitle(post.getTitle());
        posts.get((int) id).setBody(post.getBody());
    }

    private void createPosts() {
        save(new Post("Post A", "This is the body of post A"));
        save(new Post("Post B", "This is the body of post B"));
        save(new Post("Post C", "This is the body of post C"));
    }
}
