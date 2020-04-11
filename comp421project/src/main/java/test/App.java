package test;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
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

		// Commands to execute Look up Nail Artist Query
		// LookUpNailArtistController.LookUp(statement, "severus.snape@gmail.com");

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
}
