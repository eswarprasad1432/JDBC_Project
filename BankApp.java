package com.kodnest.bank;

import java.util.Scanner;

public class BankApp {

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		while(true)
		{
			System.out.println("Welcome to BK bank ");
			System.out.println("1.Registartion\n 2.Login\n 3.Check Balance\n 4.Update Password\n 5.Update Profile\n 6.Delete Profile\n 7.Stop");
			System.out.println("Enter Your choice");
			int choice=scanner.nextInt();
			 KodnestBank kb=KodnestBank.getInstance();
			switch(choice)
			{
			case 1:
			{
				System.out.println("welcome To Registration Page");
				kb.Registration();
				break;
			}
			case 2:
			{
				System.out.println("Welcome to Login Page");
				kb.login();
				break;
			}
			case 3:
			{
				System.out.println("You can check ur balance here");
				break;
			}
			case 4:
			{
				System.out.println("Update Password here");
				break;
			}
			case 5:
			{
				System.out.println("Update Profile");
				break;
			}
			case 6:
			{
				System.out.println("Delete Profile");
				break;
			}
			case 7:
			{
				System.exit(0);
			}
			default:
			{
				System.out.println("Enter Valid Choice You A**");
			}
		  }
	}
		

  }
	
}
