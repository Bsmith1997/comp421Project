package test;
import java.sql.* ;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import test.AddUserToRewardProgramController;


public class App
{
    public static void main ( String [] args ) throws SQLException
    {
    try {
    DriverManager.registerDriver ( new org.postgresql.Driver() ) ;
} catch (Exception cnfe){
    System.out.println("Class not found");
    }

// This is the url you must use for Postgresql.
//Note: This url may not valid now !
String url = "jdbc:postgresql://comp421.cs.mcgill.ca:5432/cs421";
String username = "cs421g14"; 
String password = "Comp421g14"; 
Connection con = DriverManager.getConnection (url,username, password) ;
Statement statement = con.createStatement() ;
String useremail = "john.doe@shakespear.com"; 
String userphonenumer = null; 
String name = "John Doe"; 
String useraddress = "100 Fake Street"; 
boolean userExisted = AddUserToRewardProgramController.CheckIfUserexisted(statement, useremail); 
if(userExisted){
	AddUserToRewardProgramController.AddExsitedUserToLoyaltyProgram(statement, "6", "Calendar"); 
}
else{
	AddUserToRewardProgramController.AddNonExsitedUserToLoyaltyProgram(statement, useremail, userphonenumer, name, useraddress, "6", "Calendar");
}


	// // Querying a table
	// 	try {
	// 		String querySQL = "SELECT * from  customer WHERE email = "+email;
	// 		System.out.println (querySQL) ;
	// 		java.sql.ResultSet rs = statement.executeQuery ( querySQL ) ;
	// 		while ( rs.next ( ) ) {
	// 		int id = rs.getInt ( 1 ) ;
	// 		String name = rs.getString (2);
	// 		System.out.println ("id:  " + id);
	// 		System.out.println ("name:  " + name);
	// 		}
	// 		System.out.println ("DONE");
	// 	} catch (SQLException e)
	// 		{
	// 		sqlCode = e.getErrorCode(); // Get SQLCODE
	// 		sqlState = e.getSQLState(); // Get SQLSTATE
					
	// 		// Your code to handle errors comes here;
	// 		// something more meaningful than a print would be good
	// 		System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
	// 		}

	// //Updating a table
    // 	try {
	//     String updateSQL = "UPDATE " + tableName + " SET NAME = \'Mimi\' WHERE id = 3";
	//     System.out.println(updateSQL);
	//     statement.executeUpdate(updateSQL);
	//     System.out.println("DONE");

	//     // Dropping a table
	//     String dropSQL = "DROP TABLE " + tableName;
	//     System.out.println ( dropSQL ) ;
	//     statement.executeUpdate ( dropSQL ) ;
	//     System.out.println ("DONE");
	// } catch (SQLException e)
	//     {
	// 	sqlCode = e.getErrorCode(); // Get SQLCODE
	// 	sqlState = e.getSQLState(); // Get SQLSTATE
                
	// 	// Your code to handle errors comes here;
	// 	// something more meaningful than a print would be good
	// 	System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
	//     }


	// Finally but importantly close the statement and connection
	statement.close ( ) ;
	con.close ( ) ;
    }
}

