package com.codeup.blog.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    Post save(Post post);
    void delete(Post post);
    void delete(Long id);
    Post findOne(Long id);
    List<Post> findAll();
}
