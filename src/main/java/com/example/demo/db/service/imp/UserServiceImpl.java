package com.example.demo.db.service.imp;

import com.example.demo.db.bean.DbEnum;
import com.example.demo.db.bean.User;
import com.example.demo.db.config.SwitchDs;
import com.example.demo.db.dao.UserMapper;
import com.example.demo.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by michangtao in 2020/1/8 16:30
 */
@Service("UserService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @SwitchDs(name = DbEnum.db2)
    @Override
    public List<User> selectAllUser() {
        List<User> list = userMapper.selectAllUser();
        return list;
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
