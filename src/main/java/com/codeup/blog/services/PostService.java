package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postDao;

    public PostService(PostRepository postDao) {
        this.postDao = postDao;
    }

    public Iterable<Post> getAllPosts() {
        return postDao.findAll();
    }

    public Post getPost(long id) {
        return postDao.findOne(id);
    }

    public Post save(Post post) {
        return postDao.save(post);
    }

    public void delete(Long id) {
        postDao.delete(id);
    }
}
