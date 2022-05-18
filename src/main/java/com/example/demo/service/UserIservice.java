package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.example.demo.bean.IUser;
import com.example.demo.form.UserForm;
import com.example.demo.mapper.UserMapper;
@Service("userService")
public class UserIservice implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private MessageSource messageSource;
    public List<String> getResult (UserForm userForm){
        IUser user = userMapper.queryUser(userForm.getAccountId()); 
        List<String> errorlist = new ArrayList<String>(); 
        if (user == null) { 
            errorlist.add("login.message.accountId.error"); 
            } 
        else if (!user.getPassword().equals(userForm.getPassword())) { 
            errorlist.add("login.message.password.error");
        }
    return errorlist;
    }
}