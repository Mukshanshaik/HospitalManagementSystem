package com.hospital.management;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService 
{
	public static Connection connection;
	
	private static Connection createconnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root" ,"Muskhan@123");
		System.out.println("Database connection is created successfully");
		return connection;
	}
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		if(connection == null)
		{
			return createconnection();
		}
		return connection;
	}
}
