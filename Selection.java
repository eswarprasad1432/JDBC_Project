package com.jdbc.connection;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Selection 
{
    @SuppressWarnings("unused")
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM details WHERE age = ?";
        String url = "jdbc:mysql://localhost:3306/rohitha_results";
        String user = "root";
        String pass = "1432@BK";

        try 
        {
            System.out.println("Loading Driver Is Initiated");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Loading Driver is Successful");
            System.out.println("Establishing Connection Is Initiated");
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Establishing Connection Is Successful");
            System.out.println("PreparedStatement Creation is Initiated");
            preparedStatement = connection.prepareStatement(sql);

            System.out.println("Enter the age ");
            int age = scanner.nextInt();
            preparedStatement.setInt(1, age);

            System.out.println("Executing the Query is Initiated");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.print(resultSet.getString("name") + " " + resultSet.getInt("age") + " " + resultSet.getString("gender")+" ");
            }

            scanner.close();
            connection.close();
            resultSet.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
