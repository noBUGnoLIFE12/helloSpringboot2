package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.form.UserForm;
import com.example.demo.service.UserService;
@Controller
@ComponentScan({"service"})
@MapperScan("com.example.demo.mapper")
public class Login {
    @Resource
    private UserService userService;
    //ログイン画面の表示
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@ModelAttribute("form") UserForm userForm, Model model) {
        return ("/login");
    }
    //ユーザIdとパスワードの検証
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String auth(@ModelAttribute("form") @Valid UserForm userForm, BindingResult result, Model model) {
        String url = null;
        if (result.hasErrors()) {
            List<ObjectError> errorList = result.getAllErrors();
            // エラーメッセージを画面返却情報に入れる
            model.addAttribute("errorList", errorList);
            // 画面遷移の指定
            url = "/login";
            return url;
        }
        List<String> errorlist = userService.getResult(userForm);
        if (!(errorlist.size() == 0)) {
            model.addAttribute("message", errorlist.get(0));
            // 画面遷移の指定
            url = "/login";
            return url;
        } else {
            // 画面遷移の指定
            url = "/success";
            return url;
        }
    }
}