package com.codeup.blog.services;

import com.codeup.blog.models.User;
import com.codeup.blog.models.UserRepository;
import com.codeup.blog.models.UserWithRoles;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userDao;

    public UserService(UserRepository userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' Not Found!", username));
        }
        return new UserWithRoles(user);
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
