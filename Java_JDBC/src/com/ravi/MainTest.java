package com.ravi;

import com.ravi.db.UserDAO;

import model.User;

public class MainTest {

	public static void main(String[] args) {
		//DBConnection.getConnection();
		UserDAO userDao = new UserDAO();
		//userDao.getAllUsers();
		//System.out.println("Get User");
		//User user = userDao.getUsers("1001");
		//user.setId("1002");
		//userDao.insertUser(user);
		
		User u = new User();
		u.setId("1003");
		u.setUsername("pratik");
		u.setPassword("zade");
		//System.out.println("Insert User");
		//userDao.insertUser(u);
		
		System.out.println("Update User");
		User user1 = userDao.getUsers("1002");
		user1.setPassword("vip");
		userDao.updateUser(user1);
		//userDao.getAllUsers();

	}

}
