package test;

import java.sql.*;
import java.sql.SQLException;

public class LookUpNailArtistController {

	public static void LookUp(Statement statement, String nailArtistEmail) {
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