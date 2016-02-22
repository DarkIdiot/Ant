package com.dark.cobertura.service.imp;

/**
 * @author idiot
 * @version 1.0
 * @date 2015��12��29�� ����4:13:08
 */

import java.util.HashMap;
import java.util.Map;

import com.dark.cobertura.exception.UserException;
import com.dark.cobertura.model.User;
import com.dark.cobertura.service.IUserService;


public class UserServiceByMap implements IUserService {
	private Map<String, User> us = new HashMap<String, User>();
	
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		if(load(user.getUsername()) != null){
			throw new UserException("�û����Ѵ���");
		}
		us.put(user.getUsername(), user);
	}

	@Override
	public void delete(String username) {
		us.remove(username);
	}
	@Override
	public User load(String username) {
		return us.get(username);
	}

	@Override
	public User login(String username, String password) {
		User u = load(username);
		if(u==null) throw new UserException("�û���������");
		if(!u.getPassword().equals(password)) throw new UserException("�û����벻��ȷ");
		return u;
	}

}
