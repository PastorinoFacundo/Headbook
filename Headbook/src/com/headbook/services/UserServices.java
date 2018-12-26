package com.headbook.services;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.headbook.converters.UserConverter;
import com.headbook.db.mappers.UsersMapper;
import com.headbook.db.model.Users;
import com.headbook.modelo.User;

@Service
public class UserServices {

	@Autowired
	UsersMapper usersMapper;
	@Autowired
	UserConverter userConverter;
	
	public User getUser(Long id) throws MalformedURLException {
		Users userDB = usersMapper.selectByPrimaryKey(id);
		User user = userConverter.UserDBToUser(userDB);
		return user;
	}
	
}
