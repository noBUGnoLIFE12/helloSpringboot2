package com.example.demo.service;

import java.util.List;

import com.example.demo.form.UserForm;
public interface UserService {
    //public IUser queryUser(String accountId);
    public List<String> getResult(UserForm userForm);
}
