package com.jeremy.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeremy.dao.UserDAO;
import com.jeremy.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Override
	public User login(String username,String password) {

		return userDAO.login(username, password);


	}
	@Override
	public void register(User user) {
		user.setId(UUID.randomUUID().toString());
		userDAO.save(user);

}
}