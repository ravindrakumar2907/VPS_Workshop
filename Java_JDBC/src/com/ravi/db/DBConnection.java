package com.ravi.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection connection;

	private DBConnection() {
	}

	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/demo";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, "root", "root");
			System.out.println("Success");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("error");
			return null;
		}
		return connection;

	}
}

/***
 * Two ways to load the jar file: Paste the mysqlconnector.jar file in
 * jre/lib/ext folder Set classpath set
 * classpath=c:\folder\mysql-connector-java-5.0.8-bin.jar;.;
 * 
 */