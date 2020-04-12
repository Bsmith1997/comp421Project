package test;

import java.sql.*;
import java.util.Scanner;

import test.AddUserToRewardProgramController;
import test.LookUpNailArtistController;
import test.MakeAndCancelAppointment;
import test.MakeRatingController;

public class App {
	public static void main(String[] args) throws SQLException {
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
			
		} catch (Exception cnfe) {
			System.out.println("Class not found");
		}

		// This is the url you must use for Postgresql.
		// Note: This url may not valid now !
		String url = "jdbc:postgresql://comp421.cs.mcgill.ca:5432/cs421";
		String username = "cs421g14";
		String password = "Comp421g14";
		Connection con = DriverManager.getConnection(url, username, password);
		Statement statement = con.createStatement();
		String useremail = "john.doe@shakespear.com";
		String userphonenumer = null;
		String name = "John Doe";
		String useraddress = "100 Fake Street";
		
boolean continueLoop = true;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Hello, welcome to the Nail Salon Management System and Database!");
        System.out.println("What would you like to do?");
        
        while(continueLoop) {
            
            System.out.println("---------------------------");
            System.out.println("Select one of the following options to continue:");
            System.out.println("---------------------------");
            System.out.println("1) Look up a nail artist's appointments.");
            System.out.println("2) Make an appointment.");
            System.out.println("3) Cancel an appointment.");
            System.out.println("4) Add an existing user to the rewards program.");
            System.out.println("5) Add a new user to the rewards program.");
            System.out.println("6) Make a rating");
            System.out.println("6) Quit.");
            System.out.println("---------------------------");
                
            boolean validInput = false;
            do{
                if(scanner.hasNextInt()){
                    
                    int userInput = scanner.nextInt();
                    if((userInput >= 1) && (userInput <= 6)) {      
                        validInput = true;
         
                        if(userInput == 1){
                          LookUpNailArtistController.LookUp(scanner, statement);
                          break; 
                        } else if(userInput == 2){
                          MakeAndCancelAppointment.MakeCustomAppointment(scanner, statement);
                          break;
                        } else if(userInput == 3){
                          MakeAndCancelAppointment.CancelAppointment(scanner, statement);
                        } else if(userInput == 4){
                              AddUserToRewardProgramController.AddExsitedUserToLoyaltyProgram(scanner, statement);
                        } else if(userInput == 5){
                          AddUserToRewardProgramController.AddNonExsitedUserToLoyaltyProgram(scanner,statement);
                        } else if(userInput == 6){
                          MakeRatingController.MakeARating(scanner, statement);
                        }else{
                            System.out.println("Thank you for using the Nail Salon Management System and Database!");
                            continueLoop = false;
                        }
                    } else {
                        System.out.println("Enter a valid option from 1-6");
                    }
                } else{
                    scanner.nextLine();
                    System.out.println("Enter a valid option from 1-6:");
                }
                
            }while(!validInput);
          }
        
        scanner.close();
		statement.close();
		con.close();
	}

}

