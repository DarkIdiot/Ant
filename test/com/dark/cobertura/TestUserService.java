package com.dark.cobertura;

/**
 * @author idiot
 * @version 1.0
 * @date 2015��12��29�� ����4:11:09
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.dark.cobertura.exception.UserException;
import com.dark.cobertura.model.User;
import com.dark.cobertura.service.IUserService;
import com.dark.cobertura.service.imp.UserServiceByMap;



public class TestUserService {
	private IUserService us;
	private User baseUser;
	
	@Before
	public void setUp(){
		// ��ʼ��
		us = new UserServiceByMap();
		baseUser = new User("admin", "123", "����Ա");
	}
	
	private void assertUserEquals(User u, User tu){
		assertEquals("add�����д���!", u.getUsername(), tu.getUsername());
		assertEquals("add�����д���!", u.getNickname(), tu.getNickname());
		assertEquals("add�����д���!", u.getPassword(), tu.getPassword());
	}
	
	@Test
	public void testAdd(){
		User u = baseUser;
		us.add(u);
		User tu = us.load("admin");
		assertNotNull(tu);
		assertUserEquals(u, tu);
		//fail("�������ӵĲ��Դ���");
	}
	
	@Test(expected=UserException.class)
	public void AddExistUsername(){
		us.add(baseUser);
		User tu = new User("admin", "1234", "alskdf");
		us.add(tu);
	}
	
	@Test
	public void testDelete(){
		us.add(baseUser);
		User tu = us.load(baseUser.getUsername());
		assertNotNull(tu);
		us.delete(baseUser.getUsername());
		tu = us.load(baseUser.getUsername());
		assertNull(tu);
	}
	
	@Test
	public void testLogin(){
 		us.add(baseUser);
		String username=baseUser.getUsername();
		String password=baseUser.getPassword();
		User tu = us.login(username, password);
		assertUserEquals(baseUser, tu);
	}
	
	@Test(expected=UserException.class)
	public void testNotExistsUserLogin(){
		us.add(baseUser);
		String username="admin1";
		String password="123";
		us.login(username, password);
 	}
	
	@Test(expected=UserException.class)
	public void testPasswordErrorUserLogin(){
		us.add(baseUser);
		String username="admin";
		String password="1235";
		us.login(username, password);
	}
}

