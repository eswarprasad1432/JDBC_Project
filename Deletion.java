package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Deletion {

	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		String path="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/rohitha_results";
		String user="root";
		String pass="1432@BK";
		String sql="DELETE FROM DETAILS WHERE NAME=?;";
		
		try 
		{
			System.out.println("Loading The Driver is Initiated......");
			Class.forName(path);
			System.out.println("Loading The Driver is Successfull");
			System.out.println("------------------------------------------------");
			System.out.println("Establishing the connection is Initiated.....");
			Connection connection=DriverManager.getConnection(url, user, pass);
			System.out.println("Establishing Connection is Successful");
			System.out.println("--------------------------------------");
			System.out.println("Statement Creation is Initiated.......");
			PreparedStatement statement=connection.prepareStatement(sql);
			System.out.println("Statement Creation is successful");
			System.out.println("--------------------------------------");
			System.out.println("Exceute the query");
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter the name");
			String name=scan.nextLine();
			statement.setString(1, name);
			int nora=statement.executeUpdate();
			System.out.println(nora+"row(s) affected");
			scan.close();
			connection.close();
			statement.close();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}
