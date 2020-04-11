package test;

import java.sql.*;
import java.sql.SQLException;

public class MakeRatingController {
    public static void MakeARating(Statement statement, String cemail, String nemail, String reviewid, String rating,
            String content, String locationname) {
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