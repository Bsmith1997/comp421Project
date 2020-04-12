package test;

import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;

public class MakeRatingController {
    public static void MakeARating(Scanner scanner, Statement statement){
      System.out.println("Enter the email address of the customer making the rating:");
      Scanner scanner1 = new Scanner(System.in);
      if (scanner1.hasNext()){
        String cemail = scanner1.nextLine(); 
        System.out.println("Enter the email address of the nail artist being reviewed:");
        String nemail = scanner1.nextLine(); 
        System.out.println("Enter the review id of the rating:");
        String reviewid = scanner1.nextLine(); 
        System.out.println("Enter the rating (out of 5):");
        String rating = scanner1.nextLine();
        System.out.println("Enter the text of the rating:");
        String content = scanner1.nextLine();
        System.out.println("Enter the location that the rating relates to:");
        String locationname = scanner1.nextLine();
        if (reviewid == "" || reviewid == null) {
            System.out.println("Review ID cannot be null or empty");
            return;
        }
        if (cemail == "" || cemail == null) {
            System.out.println("Customer email cannot be null or empty");
            return;
        }
        int sqlCode = 0; // Variable to hold SQLCODE
        String sqlState = "00000"; // Variable to hold SQLSTATE
        int reviewID = Integer.parseInt(reviewid);
        try {
            String insertSQLTowrites = "INSERT INTO writes VALUES ( \'" + cemail + "\' ," + reviewID + ") ";
            String insertSQLToreceives = "INSERT INTO receives VALUES ( " + reviewID + ", \'" + nemail + "\') ";
            String insertSQLToreview = "INSERT INTO review VALUES ( " + reviewID + ", \'" + content + "\', \'" + rating
                    + "\', \'" + locationname + "\') ";
            System.out.println(insertSQLToreview);
            statement.executeUpdate(insertSQLToreview);
            System.out.println(insertSQLTowrites);
            statement.executeUpdate(insertSQLTowrites);
            System.out.println(insertSQLToreceives);
            statement.executeUpdate(insertSQLToreceives);
            System.out.println("DONE");

        } catch (SQLException e) {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE
            System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
        }
    }
  }
}