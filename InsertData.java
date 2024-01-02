package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertData {

	public static void main(String[] args) 
	{
		String url="jdbc:mysql://localhost:3306/rohitha_results";
		String user="root";
		String pass="1432@BK";
		String Insert_Query= "INSERT INTO DETAILS(NAME,AGE,GENDER) VALUES(\"ESWAR\",22,\"M\"),(\"ROHITHA\",21,\"F\");";
		try
		{
			System.out.println("Loading The Driver Initiated");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loading Driver is Successful");
			System.out.println("Connection Establishment is Initaited");
			Connection connection =DriverManager.getConnection(url, user, pass);
			System.out.println("Connection Establishment is Successful");
			System.out.println("Statement Creation is Initiated");
			Statement statement =connection.createStatement();
			System.out.println("Statement Creation is Successful");
			System.out.println("Query Execution is Initaited......");
			statement.execute(Insert_Query);
			System.out.println("Data is Inserted...");
			System.out.println("Resources Cleaning Initaited");
			connection.close();
			statement.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		

	}

}
