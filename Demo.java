package com.jdbc.connection;

import java.sql.DriverManager;
import java.sql.Connection;

public class Demo {

	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		String url="jdbc:mysql://localhost:3306/buchammagarifamily";
		String user="root";
		String pass="1432@BK";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Successfully");
			Connection conn=DriverManager.getConnection(url, user, pass);
			System.out.println("Connection Esatblished Successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
