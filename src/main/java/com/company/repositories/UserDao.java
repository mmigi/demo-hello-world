package com.company.repositories;

import com.company.model.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * User repository
 */
@Transactional
public interface UserDao extends CrudRepository<User, String> {
    User findUserByName(String name);
}
