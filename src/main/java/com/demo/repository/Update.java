package com.demo.repository;

import com.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hanqiang.chen on 11/27/2018.
 */
public interface Update extends JpaRepository<User, Long>{
    User findByName(String name);
    User findByEmail(String email);
    User findByUsername(String username);
    User findByPassword(String password);
    User findById(long id);
}
