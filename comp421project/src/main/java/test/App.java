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
            System.out.println("4) Add a user to the rewards program.");
            System.out.println("5) Make a rating");
            System.out.println("6) Quit.");
            System.out.println("---------------------------");
                
            boolean validInput = false;
            
            do{
                
                if(scanner.hasNextInt()){
                    
                    int userInput = scanner.nextInt();
                    
                    if((userInput >= 1) && (userInput <= 6)) {
                        
                        validInput = true;
                      
                        
                        if(userInput == 1){
                          LookUp(scanner, statement);
                          break; 
                        }
                        
                        else if(userInput == 2){
                          MakeCustomAppointment(scanner, statement);
                          break;
                        }
                        
                        else if(userInput == 3){
                        
                        }
                        
                        else if(userInput == 4){
                            
                        }
                        
                        else if(userInput == 5){
                            
                        }
                        
                        else{
                            System.out.println("Goodbye.");
                            continueLoop = false;
                        }
                    }
                    
                    else {
                        System.out.println("Enter a valid option from 1-6");
                    }
                }
                
                else{
                    scanner.nextLine();
                    System.out.println("Enter a valid option from 1-6:");
                }
                
            }while(!validInput);
            
            
            
        }
        
        scanner.close();


		// Commands to Add user into Loyalty Program
		// boolean userExisted =
		// AddUserToRewardProgramController.CheckIfUserexisted(statement, useremail);
		// if(userExisted){
		// AddUserToRewardProgramController.AddExsitedUserToLoyaltyProgram(statement,
		// "6", "Calendar");
		// }
		// else{
		// AddUserToRewardProgramController.AddNonExsitedUserToLoyaltyProgram(statement,
		// useremail, userphonenumer, name, useraddress, "6", "Calendar");
		// }


		// Commands to Make and Cancel Appointment
		// MakeAndCancelAppointment.MakeCustomAppointment(statement, "11:00:00",
		// useremail, "13:00:00", "2020-04-11", "1111 3333 5555 6666",
		// "severus.snape@gmail.com", "Azkaban");
		// MakeAndCancelAppointment.MakeAppointmentToday(statement, useremail, "1111
		// 3333 5555 6666", "severus.snape@gmail.com", "Azkaban");
		// MakeAndCancelAppointment.CancelAppointment(statement, "11:00:00", useremail,
		// "2020-04-11");
		
		//Commands to make a rating
		// MakeRatingController.MakeARating(statement, useremail, "severus.snape@gmail.com", "9", "2", "Not bad", "Azkaban");
		// Finally but importantly close the statement and connection
		statement.close();
		con.close();
	}
	
	public static void LookUp(Scanner scanner, Statement statement) {
        System.out.println("Enter the email address of the nail artist you want to view the appointments of:");
        Scanner scanner1 = new Scanner(System.in);
        if (scanner1.hasNext()){
          String nailArtistEmail = scanner1.nextLine();
        if (nailArtistEmail == "" || nailArtistEmail == null) {
            System.out.println("Nail Artists' email cannot be null or empty");
            return;
        } 
          try {
        
          String lookUpSQLInAppointments = "SELECT starttime, cemail FROM  appointment WHERE nartistemail = \'"
                  + nailArtistEmail + "\'";
          System.out.println(lookUpSQLInAppointments);
          ResultSet rs = statement.executeQuery(lookUpSQLInAppointments);
          while (rs.next()) {
              // Retrieve by column name
              String startTime = rs.getString("starttime");
              String email = rs.getString("cemail");

              // Display values
              System.out.print("Start Time: " + startTime);
              System.out.println(", Customer Email: " + email);
          }
          System.out.println("DONE");

      } catch (SQLException e) {
          System.out.println("Error: Failed to execute command");
          e.printStackTrace();
          }
        }
	}
	
	 public static void MakeCustomAppointment(Scanner scanner, Statement statement) {
	   System.out.println("Enter the start time of the appointment (HH:MM:SS):");
	   Scanner scanner1 = new Scanner(System.in);
       if (scanner1.hasNext()){
         String starttime = scanner1.nextLine(); 
         System.out.println("Enter the customer's email address:");
         String cemail = scanner1.nextLine(); 
         System.out.println("Enter the end time of the appointment (HH:MM:SS):");
         String endtime = scanner1.nextLine(); 
         System.out.println("Enter the date of the appointment (M/D/Y):");
         String appdate = scanner1.nextLine(); 
         System.out.println("Enter the credit card number of the customer:");
         String creditcardnumber = scanner1.nextLine();
         System.out.println("Enter the nail artist's email address:");
         String nartistemail = scanner1.nextLine(); 
         System.out.println("Enter the location of the appointment:");
         String locationname = scanner1.nextLine();
     // make appointment with some custom starttime, endtime and apppointment date
     if (nartistemail == "" || nartistemail == null) {
         System.out.println("Nail Artist Email cannot be null or empty");
         return;
     }
     if (cemail == "" || cemail == null) {
         System.out.println("Customer email cannot be null or empty");
         return;
     }
     if (locationname == "" || locationname == null) {
         System.out.println("Location name cannot be null or empty");
         return;
     }
     if (starttime == "" || starttime == null) {
         System.out.println("Start Time cannot be null or empty");
         return;
     }
     if (endtime == "" || endtime == null) {
         System.out.println("End time cannot be null or empty");
         return;
     }
     if (appdate == "" || appdate == null) {
         System.out.println("Appointment Date cannot be null or empty");
         return;
     }

     int sqlCode = 0; // Variable to hold SQLCODE
     String sqlState = "00000"; // Variable to hold SQLSTATE
     try {
         String insertSQLToAppointment = "INSERT INTO appointment VALUES ( \'" + starttime + "\',  \'" + cemail
                 + "\',  \'" + endtime + "\',  \'" + appdate + "\',  \'" + creditcardnumber + "\', \'" + nartistemail
                 + "\', \'" + locationname + "\') ";
         System.out.println(insertSQLToAppointment);
         statement.executeUpdate(insertSQLToAppointment);
         System.out.println("DONE");

     } catch (SQLException e) {
         sqlCode = e.getErrorCode(); // Get SQLCODE
         sqlState = e.getSQLState(); // Get SQLSTATE
         System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
       }
      }
	}
}
