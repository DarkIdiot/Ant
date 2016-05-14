package com.dark.cobertura.service;

import com.dark.cobertura.model.User;

/**
 * @author idiot
 * @version 1.0
 * @date 2015年12月29日 下午4:07:48
 */


public interface IUserService {
	public void add(User user);
	
	public void delete(String username);
	
	public User load(String username);
	
	public User login(String username, String password);
}


