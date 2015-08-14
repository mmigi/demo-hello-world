package com.company.services;

import com.company.model.User;
import com.company.model.UserCreateForm;
import com.company.repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * User service
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User createUser(UserCreateForm form) {
        User currentUser = new User();
        currentUser.setName(form.getName());
        currentUser.setPassword(getPasswordHash(form.getPassword()));
        userDao.save(currentUser);
        return currentUser;
    }

    @Override
    public User findUser(String name) {
        return userDao.findUserByName(name);
    }

    private String getPasswordHash(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
