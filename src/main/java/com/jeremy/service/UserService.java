package com.jeremy.service;

import com.jeremy.entity.User;

public interface UserService {
	void  register(User user);
User login(String usename,String password);
}
