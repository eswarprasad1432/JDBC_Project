package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Updation {

	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		String path="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/Rohitha_results";
		String user="root";
		String pass="1432@BK";
		String sql1="SELECT * FROM DETAILS;";
		String sql2="UPDATE DETAILS SET NAME=? WHERE AGE=?;";
		
		Scanner scan=new Scanner(System.in);
		
		try 
		{
			System.out.println("LOADING DRIVER.....");
			Class.forName(path);
			System.out.println("LOADING DRIVER Success..");
			System.out.println("Establishing Connection is Initiated");
			Connection connection=DriverManager.getConnection(url, user, pass);
			System.out.println("Establishing connection is Successful");
			System.out.println("Statement Creation is  Initiated");
			PreparedStatement statement=connection.prepareStatement(sql1);
			System.out.println("Executing Selection Query");
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next())
			{
				System.out.println(resultSet.getString("Name")+" "+resultSet.getInt("Age")+" "+resultSet.getString("Gender"));
			}
			System.out.println("Selection Query is executed");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Exceute Update Query");
			System.out.println("Enter the New Name to be updated");
			String new_name=scan.nextLine();
			System.out.println("Enter the age");
			int age=scan.nextInt();
			statement=connection.prepareStatement(sql2);
			statement.setString(1,new_name);
			statement.setInt(2, age);
			int nora=statement.executeUpdate();
			System.out.println(nora+" row(s) affected");
			System.out.println("Update Query is executed");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		    statement=connection.prepareStatement(sql1);
			System.out.println("Executing Selection Query");
			resultSet=statement.executeQuery();
			while(resultSet.next())
			{
				System.out.println(resultSet.getString("Name")+" "+resultSet.getInt("Age")+" "+resultSet.getString("Gender"));
			}
			System.out.println("Selection Query is executed");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			scan.close();
			connection.close();
			statement.close();
			resultSet.close();	
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
