package com.ravi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

/**
 * 
 * @author RAVI
 * User DAO
 */
public class UserDAO { // DAO- Data Access Object

	/***
	 *  Returns all users 
	 * @return List<User>
	 */
	public List<User> getAllUsers() {
		List<User> userList = null;
		try {
			Connection connection = DBConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user");
			userList = new ArrayList<>();
			while (rs.next()) {
				User u = new User();
				u.setId(String.valueOf(rs.getInt("id")));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				userList.add(u);
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			}
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}

	/**
	 * Returns single user by id
	 * @param id
	 * @return User
	 */
	public User getUsers(String id) {
		User user = null;
		try {
			Connection connection = DBConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user where id=" + id);
			while (rs.next()) {
				user = new User();
				user.setId(String.valueOf(rs.getInt("id")));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			}
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	
	/**
	 * Insert the user in db
	 * @param user
	 * @return boolean
	 */
	public Boolean insertUser(User user) {
		Connection connection = null;
		Boolean isInserted = false;
		try {
			connection = DBConnection.getConnection();
			String query = "INSERT INTO user (id, username, password) values (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(user.getId()));
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			isInserted = ps.execute();
			System.out.println("Inserted");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}

		return isInserted;
	}

	/***
	 * Update user in DB
	 * @param user
	 * @return boolean
	 */
	public Boolean updateUser(User user) {
		Connection connection = null;
		Boolean isUpdated = false;
		try {
			connection = DBConnection.getConnection();
			String query = "UPDATE user SET password= ?, username= ? where id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getUsername());
			ps.setInt(3, Integer.parseInt(user.getId()));

			isUpdated = ps.execute();
			if (isUpdated) {
				System.out.println("Updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}

		return isUpdated;
	}

	/**
	 * Update the password
	 * @param password
	 * @param id
	 * @return Boolean
	 */
	public Boolean updatePassword(String password, String id) {
		Connection connection = null;
		Boolean isUpdated = false;
		try {
			connection = DBConnection.getConnection();
			String query = "UPDATE user SET password= ? where id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, password);
			ps.setInt(2, Integer.parseInt(id));
			isUpdated = ps.execute();
			if (isUpdated) {
				System.out.println("Updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}

		return isUpdated;
	}

	
	/**
	 * Update the userName
	 * @param username
	 * @param id
	 * @return Boolean
	 */
	public Boolean updateUsername(String username, String id) {
		Connection connection = null;
		Boolean isUpdated = false;
		try {
			connection = DBConnection.getConnection();
			String query = "UPDATE user SET username= ? where id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username);
			ps.setInt(2, Integer.parseInt(id));
			isUpdated = ps.execute();
			if (isUpdated) {
				System.out.println("Updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}

		return isUpdated;
	}
}
