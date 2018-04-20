package com.codeup.blog.models;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userDao;

    public UserService(UserRepository userDao) {
        this.userDao = userDao;
    }

    public Iterable<User> getAllUsers() {
        return userDao.findAll();
    }

    public User getUser(long id) {
        return userDao.findOne(id);
    }

    public User save(User user) {
        return userDao.save(user);
    }

    public void delete(long id) {
        userDao.delete(id);
    }
}
