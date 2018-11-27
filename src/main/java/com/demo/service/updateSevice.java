package com.demo.service;

import com.demo.entity.User;
import com.demo.repository.Update;
import com.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hanqiang.chen on 11/27/2018.
 */
@Service
public class updateSevice implements Update{
    private static Map<String, User> userHashMap = new HashMap<>();
    @Override
    public void updateUser(String id, User user) {
        userHashMap.remove(id);
        user.setId(id);
        userHashMap.put(id, user);
    }
}
