package test;

import java.sql.*;
import java.lang.System;
import java.util.Date;
import java.util.Scanner;

public class MakeAndCancelAppointment {

  public static void MakeCustomAppointment(Scanner scanner, Statement statement) {
    System.out.println("Enter the start time of the appointment (HH:MM:SS):");
    Scanner scanner1 = new Scanner(System.in);
    if (scanner1.hasNext()){
      String starttime = scanner1.nextLine(); 
      System.out.println("Enter the customer's email address:");
      String cemail = scanner1.nextLine(); 
      System.out.println("Enter the end time of the appointment (HH:MM:SS):");
      String endtime = scanner1.nextLine(); 
      System.out.println("Enter the date of the appointment (YYYY-MM-DD):");
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

    public static void MakeAppointmentToday(Statement statement, String cemail, String creditcardnumber,
            String nartistemail, String locationname) {
        // make appointment with today's date as appointment date,
        // with current time as starttime, and 2 hours as duration
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

        int sqlCode = 0; // Variable to hold SQLCODE
        String sqlState = "00000"; // Variable to hold SQLSTATE
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Time sqlStart = new Time(System.currentTimeMillis());
        Time sqlEnd = new Time(System.currentTimeMillis() + 2 * 3600000);
        String appdate = sqlDate.toString();
        String starttime = sqlStart.toString();
        String endtime = sqlEnd.toString();

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

    public static void CancelAppointment(Scanner scanner, Statement statement) {
      System.out.println("Enter the start time of the appointment (HH:MM:SS):");
       Scanner scanner1 = new Scanner(System.in);
       if (scanner1.hasNext()){
          String starttime = scanner1.nextLine(); 
          System.out.println("Enter the customer's email address:");
          String cemail = scanner1.nextLine(); 
          System.out.println("Enter the date of the appointment (YYYY-MM-DD):");
          String appdate = scanner1.nextLine(); 
          int sqlCode = 0; // Variable to hold SQLCODE
          String sqlState = "00000"; // Variable to hold SQLSTATE
          if (starttime == "" || starttime == null) {
              System.out.println("Start Time cannot be null or empty");
              return;
          }
          if (cemail == "" || cemail == null) {
              System.out.println("Customer email cannot be null or empty");
              return;
          }
          if (appdate == "" || appdate == null) {
              System.out.println("Appointment Date cannot be null or empty");
              return;
          }
          try {
              String deleteAppointment = "DELETE FROM appointment WHERE starttime = \'" + starttime + "\' AND cemail = \'"
                      + cemail + "\' AND appdate = \'" + appdate + "\'";
              System.out.println(deleteAppointment);
              statement.executeUpdate(deleteAppointment);
              System.out.println("DONE");
   
          } catch (SQLException e) {
              sqlCode = e.getErrorCode(); // Get SQLCODE
              sqlState = e.getSQLState(); // Get SQLSTATE
              System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
          }
      }
   }

}