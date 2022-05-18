package com.example.demo.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.bean.IUser;

@SpringBootApplication
@Mapper
public interface UserMapper {
	public IUser queryUser(String accountID);
}
