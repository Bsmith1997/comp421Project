package test;

import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;

public class AddUserToRewardProgramController {

    public static void AddExsitedUserToLoyaltyProgram(Scanner scanner, Statement statement){
      System.out.println("Enter the membership number of the customer you want to add to the loyalty program:");
      Scanner scanner1 = new Scanner(System.in);
      if (scanner1.hasNext()){
        String membershipnum = scanner1.nextLine();
        System.out.println("Enter the rewards the customer is entitled to:");
        String rewards = scanner1.nextLine();
        int sqlCode = 0; // Variable to hold SQLCODE
        String sqlState = "00000"; // Variable to hold SQLSTATE
        if (membershipnum == "" || membershipnum == null) {
            System.out.println("Membership Number cannot be null or empty");
            return;
        }
        try {
            String insertSQLToLotaltyProgram = "INSERT INTO loyaltyprogram VALUES ( " + membershipnum + ", \'" + rewards
                    + "\') ";
            System.out.println(insertSQLToLotaltyProgram);
            statement.executeUpdate(insertSQLToLotaltyProgram);
            System.out.println("DONE");

        } catch (SQLException e) {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE
            if (sqlState.equals("23503")) {
                System.out.println("This user has already being added to the loyaltyprogram.");
            }
            else{
                System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
            }
        }
      }
    }

    public static void AddNonExsitedUserToLoyaltyProgram(Scanner scanner, Statement statement){ 
      System.out.println("Enter the email of the customer you want to add to the loyalty program:");
      Scanner scanner1 = new Scanner(System.in);
      if (scanner1.hasNext()){
        String useremail = scanner1.nextLine();
        System.out.println("Enter the phone number of the customer you want to add to the loyalty program:");
        String phonenumber = scanner1.nextLine();
        System.out.println("Enter the name of the customer you want to add to the loyalty program:");
        String name = scanner1.nextLine();
        System.out.println("Enter the address of the customer you want to add to the loyalty program:");
        String address = scanner1.nextLine();
        System.out.println("Enter the membership number of the customer you want to add to the loyalty program:");
        String membershipnum = scanner1.nextLine();
        System.out.println("Enter the rewards the customer is entitled to:");
        String rewards = scanner1.nextLine();
   
        int sqlCode = 0; // Variable to hold SQLCODE
        String sqlState = "00000"; // Variable to hold SQLSTATE
        if (membershipnum == "" || membershipnum == null) {
            System.out.println("Membership Number cannot be null or empty");
            return;
        }
        if (useremail == "" || useremail == null) {
            System.out.println("Customer Email cannot be null or empty");
            return;
        }
        try {
            String insertSQLToPeople = "INSERT INTO person VALUES ( \'" + useremail + "\', \'" + phonenumber + "\', \'"
                    + name + "\', \'" + address + "\') ";
            String insertSQLToCustomer = "INSERT INTO customer VALUES ( \'" + useremail + "\', " + membershipnum + ") ";
            String insertSQLToLotaltyProgram = "INSERT INTO loyaltyprogram VALUES ( " + membershipnum + ", \'" + rewards
                    + "\') ";
            System.out.println(insertSQLToPeople);
            statement.executeUpdate(insertSQLToPeople);
            System.out.println(insertSQLToLotaltyProgram);
            statement.executeUpdate(insertSQLToLotaltyProgram);
            System.out.println(insertSQLToCustomer);
            statement.executeUpdate(insertSQLToCustomer);
            System.out.println("DONE");

        } catch (SQLException e) {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE
            System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
        }
      }
    }

    public static boolean CheckIfUserexisted(Statement statement, String useremail) {
        boolean existed = true;
        int size = 0;
        if (useremail == "" || useremail == null) {
            System.out.println("Customer Email cannot be null or empty");
            System.exit(1);
        }
        try {
            String querySQL = "SELECT * from  customer WHERE email = \'" + useremail + "\' ";
            java.sql.ResultSet rs = statement.executeQuery(querySQL);
            while (rs.next()) {
                size++;
            }
            if (size == 0) {
                existed = false;
            }
        } catch (SQLException e) {
        }
        return existed;
    }
}