package com.kodnest.bank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class KodnestBank 
{
	private Connection connection=null; 
    private Scanner scanner = new Scanner(System.in);
    String sql = "Insert into kb values(?,?,?);";
    public static KodnestBank ref = null;

    public static KodnestBank getInstance() {
        if (ref == null) 
         {
            ref = new KodnestBank();
        }
        return ref;
    }

    @SuppressWarnings("unused")
    private KodnestBank() {
        String path = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String pass = "1432@BK";
        String url = "jdbc:mysql://localhost:3306/KB_BANK";
        System.out.println("Loading is Initiated");
        try {
            Class.forName(path);
            // Assign the connection to the class-level variable
             connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Loading Driver is Done");
            System.out.println("Connection Establishing is Initiated");
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void Registration() {
        try {
            System.out.println("Enter Your Account Number");
            String acc_no = scanner.next();
            System.out.println("Enter your Password");
            String pass = scanner.next();
            System.out.println("Confirm password");
            String cpass = scanner.next();
            System.out.println("Enter Amount");
            int balance = scanner.nextInt();
            if (acc_no.length() != 9 || pass.length() != 10 || !pass.equals(cpass)) {
                System.out.println("Error");
            } else {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, acc_no);
                statement.setString(2, pass);
                statement.setInt(3, balance);
                int nora = statement.executeUpdate();
                System.out.println(nora + "row(s) affected");
                System.out.println("Successfully registered");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void login() {
        try {
            PreparedStatement statement = connection.prepareStatement("select * from kb where acc_no=? and pass=?;");
            System.out.println("Enter Your Account Number");
            String acc = scanner.next(); // Use scanner.next() instead of nextLine()
            System.out.println("Enter Password");
            String pwd = scanner.next(); // Use scanner.next() instead of nextLine()
            statement.setString(1, acc);
            statement.setString(2, pwd);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() == true) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Login Credentials are incorrect. Try Again");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
