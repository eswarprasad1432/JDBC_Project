package com.jdbc.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCConnectionDemo {

	public static void main(String[] args) 
	{
		String URL="jdbc:mysql://localhost:3306/university";
		String USER="root";
		String PASSWORD="1432@BK";
		//String create_student_query="CREATE TABLE STUDENT(ID INT,NAME VARCHAR(20),MARKS INT); ";
		// String insert_student_query=" INSERT INTO STUDENT VALUES(521,'PRASAD',99);";
		
		//String update_student_query="update eswar set name='BUNNY' where name='ESWAR';";
		String delete_student_query=" delete from eswar where name='bunny';";
		try {
			// 1. Load and Register Driver;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded successfully");
			//2. Establish the connection with the database
				Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
				System.out.println("Driver Establishment"+con);
		     // 3. Create Statement
				Statement stmt=con.createStatement();
			//    4. Send and execute Query
				// stmt.excute(create_student_query);
				// stmt.excute(insert_student_query);
				// stmt.excute(update_student_query);
				
				int rowsAffected=stmt.executeUpdate(delete_student_query);
				System.out.println(rowsAffected+" rows affected");
				System.out.println("Table Created go and check in mysql");
		}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				 System.out.println("Registration Unsuccessfil");
				e.printStackTrace();
				
			}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection Unsuccessful");
			e.printStackTrace();
			
			
		}

	}

}
