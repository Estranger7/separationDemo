package com.example.demo.db.controller;

import com.example.demo.db.bean.User;
import com.example.demo.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by michangtao in 2020/1/8 16:24
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/index")
    public List<User> index(){
        return userService.selectAllUser();
    }

    @RequestMapping("/save")
    public void insert(@RequestBody User user){
        userService.insertUser(user);
    }
}
