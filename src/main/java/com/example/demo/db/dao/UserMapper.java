package com.example.demo.db.dao;

import com.example.demo.db.bean.User;

import java.util.List;

/**
 * Created by michangtao in 2020/1/8 16:32
 */

public interface UserMapper {

    List<User> selectAllUser();

    void insertUser(User user);
}
