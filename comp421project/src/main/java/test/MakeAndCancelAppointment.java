package test;

import java.sql.*;
import java.sql.Time;
import java.lang.System;
import java.util.Date;
import java.sql.SQLException;

public class MakeAndCancelAppointment {

    public static void MakeCustomAppointment(Statement statement, String starttime, String cemail, String endtime,
            String appdate, String creditcardnumber, String nartistemail, String locationname) {
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

    public static void CancelAppointment(Statement statement, String starttime, String cemail, String appdate) {
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