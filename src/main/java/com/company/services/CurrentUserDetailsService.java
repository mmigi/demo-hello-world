package com.company.services;

import com.company.model.CurrentUser;
import com.company.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service for authorization
 */

@Service
public class CurrentUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public org.springframework.security.core.userdetails.User loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.findUser(name);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User with name=%s was not found", name));
        }
        return new CurrentUser(user);
    }

}
