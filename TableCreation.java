package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

public class TableCreation {


	public static void main(String[] args) 
	{
		String url="jdbc:mysql://localhost:3306/rohitha_results";
		String user="root";
		String pass="1432@BK";
		String Create_Table="CREATE TABLE DETAILS(NAME VARCHAR(30),AGE INT,GENDER VARCHAR(5));";
		try
		{
			System.out.println("Loading The Driver Initiated....");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Successfully");
			System.out.println("Connection Establishmemnt Initiated");
			Connection connection=DriverManager.getConnection(url, user, pass);
			System.out.println("Connectiom Established Successfully");
			System.out.println("Statement creation is initaited");
			Statement statement=connection.createStatement();
			System.out.println("Statement is created Succesfully");
			System.out.println("Statement Execution is initiated");
			statement.execute(Create_Table);
			System.out.println("Query is executed and table is created");
			System.out.println("Resources closing initiated");
			connection.close();
			statement.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
