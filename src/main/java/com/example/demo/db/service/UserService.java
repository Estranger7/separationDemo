package com.example.demo.db.service;

import com.example.demo.db.bean.User;

import java.util.List;

/**
 * Created by michangtao in 2020/1/8 16:30
 */
public interface UserService {

    List<User> selectAllUser();

    void insertUser(User user);
}
