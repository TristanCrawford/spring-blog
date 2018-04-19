package com.codeup.blog.models;

import javax.persistence.*;

@Entity
@Table(name="dogs")
public class Dog {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long age;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String reside_state;

    public Dog() {
    }

    public Dog(Long age, String name, String reside_state) {
        this.age = age;
        this.name = name;
        this.reside_state = reside_state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResideState() {
        return reside_state;
    }

    public void setResideState(String reside_state) {
        this.reside_state = reside_state;
    }
}
