package com.codeup.blog.models;

import javax.persistence.*;
import java.util.List;

@Entity @Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Post> posts;
}
