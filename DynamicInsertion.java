package com.jdbc.connection;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DynamicInsertion {

	public static void main(String[] args) 
	{
		Connection connection=null;
		PreparedStatement statement=null;
		Scanner scan=new Scanner(System.in);
		String path="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/rohitha_results";
		String user="root";
		String pass="1432@BK";
		String sql="insert into details values(?,?,?);";
		try
		{
			System.out.println("Loading Driver is Initiatetd.......");
			Class.forName(path);
			System.out.println("Loading Driver is Successful");
			System.out.println("Establishing The connectiom is Initaited");
			connection=DriverManager.getConnection(url,user,pass);
			System.out.println("Establishing Connection is Successful");
			System.out.println("PreparedStatement is Initaited....");
			statement=connection.prepareStatement(sql);
			System.out.println("Enter Your Name");
			String name=scan.next();
			System.out.println("Enter your age");
			int age=scan.nextInt();
			System.out.println("Enter your Gender");
			String Gender=scan.next();
			statement.setString(1, name);
			statement.setInt(2, age);
			statement.setString(3, Gender);
			
			int noOfRowsAffected=statement.executeUpdate();
			System.out.println(noOfRowsAffected+" row(s) affetcted");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				scan.close();
				connection.close();
				statement.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}

}
