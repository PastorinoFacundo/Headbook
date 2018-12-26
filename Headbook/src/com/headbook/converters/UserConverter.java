package com.headbook.converters;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.headbook.db.model.Users;
import com.headbook.modelo.User;

@Service
public class UserConverter {

	public User UserDBToUser(Users userDB) throws MalformedURLException {
		User user = new User();
		user.setId( userDB.getId());
		user.setAvatar(new URL(userDB.getAvatar()));
		user.setName(userDB.getName());
		user.setSurname(userDB.getSurname());
		return user;
	}
	
}
