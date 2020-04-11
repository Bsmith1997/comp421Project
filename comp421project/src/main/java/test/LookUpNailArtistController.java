package test;
import java.sql.* ;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class LookUpNailArtistController{

    public static void LookUp(Statement statement, String nailArtistEmail){
        int sqlCode=0;      // Variable to hold SQLCODE
        String sqlState="00000";  // Variable to hold SQLSTATE
	try {
	    String lookUpSQLInAppointments = "SELECT starttime, cemail FROM  appointment WHERE nartistemail = '" + nailArtistEmail + "'";
		System.out.println ( lookUpSQLInAppointments ) ;
		statement.executeUpdate ( lookUpSQLInAppointments ) ;
	    System.out.println ( "DONE" );

	} catch (SQLException e){
	  System.out.println("Error: Failed to execute command");
      e.printStackTrace();   
         }
    }

 
}