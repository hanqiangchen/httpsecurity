package com.demo.repository;

import com.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hanqiang.chen on 11/27/2018.
 */
public interface UserRepository extends JpaRepository<User, Long>  {
    User findByUsername(String username);
    User findByEmail(String email);
}
