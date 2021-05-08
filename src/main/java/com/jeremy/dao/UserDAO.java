package com.jeremy.dao;

import org.apache.ibatis.annotations.Param;

import com.jeremy.entity.User;

public interface UserDAO {
	void save(User user);

//	登录方法
   User login(@Param("username") String username,@Param("password")String password);
}
