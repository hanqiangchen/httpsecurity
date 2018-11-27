package com.demo.repository;

import com.demo.entity.User;

/**
 * Created by hanqiang.chen on 11/27/2018.
 */
public interface Update {
    public abstract void updateUser(String id, User user);
}
