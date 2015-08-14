package com.company.services;

import com.company.model.User;
import com.company.model.UserCreateForm;

/**
 * User service interface
 */
public interface UserService {
    /**
     * Creates a user ang put it in database
     *
     * @param form The form with user parameters
     * @return User
     */
    User createUser(UserCreateForm form);

    /**
     * Finds user by name
     *
     * @param name Users name
     * @return The user
     */
    User findUser(String name);
}
