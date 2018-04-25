package com.codeup.blog.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity @Table(name="posts")
public class Post {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Post Must Have A Title.")
    private String title;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    @NotBlank(message = "Post Must Have A Body.")
    private String body;

    @OneToOne
    private User author;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Images> images;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "post_categories",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private List<Categories> categories;

    public Post() {}

    public Post(String title, String body, User author) {
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
