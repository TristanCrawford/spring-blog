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

    private List<Post> posts;

    private final PostRepository postDao;

    public PostService(PostRepository postDao) {
        this.postDao = postDao;
//        createPosts();
    }

    public List<Post> getAllPosts() {
        return postDao.findAll();
    }

    public Post getPost(long id) {
        return postDao.findOne(id);
    }

    public void save(Post post) {
        postDao.save(post);
    }

    public void delete(Post post) {
        postDao.delete(post);
    }

    public void delete(Long id) {
        postDao.delete(id);
    }
}
