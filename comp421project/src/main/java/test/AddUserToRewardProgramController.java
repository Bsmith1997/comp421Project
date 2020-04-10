package test;
import java.sql.* ;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class AddUserToRewardProgramController {

    public static void AddExsitedUserToLoyaltyProgram(Statement statement, String membershipnum, String rewards){
        int sqlCode=0;      // Variable to hold SQLCODE
        String sqlState="00000";  // Variable to hold SQLSTATE
	try {
	    String insertSQLToLotaltyProgram = "INSERT INTO loyaltyprogram VALUES ( " + membershipnum + ", \'" + rewards + "\') " ;
		System.out.println ( insertSQLToLotaltyProgram ) ;
		statement.executeUpdate ( insertSQLToLotaltyProgram ) ;
	    System.out.println ( "DONE" );

	} catch (SQLException e)
            {
                sqlCode = e.getErrorCode(); // Get SQLCODE
                sqlState = e.getSQLState(); // Get SQLSTATE
                if(sqlState.equals("23503")){
                    System.out.println("This user has already being added to the loyaltyprogram."); 
                }
            }
    }

    public static void AddNonExsitedUserToLoyaltyProgram(Statement statement, String useremail, String phonenumber, String name, String address, String membershipnum, String rewards){
        int sqlCode=0;      // Variable to hold SQLCODE
        String sqlState="00000";  // Variable to hold SQLSTATE
	try {
        String insertSQLToPeople = "INSERT INTO person VALUES ( \'" + useremail + "\', \'"+phonenumber + "\', \'" + name + "\', \'" + address + "\') "; 
		String insertSQLToCustomer = "INSERT INTO customer VALUES ( \'" + useremail + "\', " + membershipnum + ") "; 
        String insertSQLToLotaltyProgram = "INSERT INTO loyaltyprogram VALUES ( " + membershipnum + ", \'" + rewards + "\') " ;
        System.out.println ( insertSQLToPeople ) ;
        statement.executeUpdate ( insertSQLToPeople ) ;
        System.out.println ( insertSQLToLotaltyProgram ) ;
		statement.executeUpdate ( insertSQLToLotaltyProgram ) ;
		System.out.println ( insertSQLToCustomer ) ;
		statement.executeUpdate ( insertSQLToCustomer ) ;
	    System.out.println ( "DONE" );

	} catch (SQLException e)
            {
                sqlCode = e.getErrorCode(); // Get SQLCODE
                sqlState = e.getSQLState(); // Get SQLSTATE
                System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
            }
    }

    public static boolean CheckIfUserexisted(Statement statement, String useremail){
        boolean existed = true;
        int size = 0; 
		try {
			String querySQL = "SELECT * from  customer WHERE email = \'john.doe@shakespear.com\' ";
			java.sql.ResultSet rs = statement.executeQuery ( querySQL ) ;
			while(rs.next()){
                size++;
            }
            if(size == 0){
                existed = false; 
            }
		} catch (SQLException e)
			{}
        return existed; 
    }
}