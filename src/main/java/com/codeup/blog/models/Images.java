package com.codeup.blog.models;

import javax.persistence.*;

@Entity @Table(name = "post_images")
public class Images {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String path;

    @ManyToOne @JoinColumn(name = "ad_id")
    private Post post;
}
