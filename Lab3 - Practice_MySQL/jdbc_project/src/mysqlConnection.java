import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class mysqlConnection {

	public static void main(String[] args) 
	{
		try 
		{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("Driver definition succeed");
        } catch (Exception ex) {
        	/* handle the error*/
        	 System.out.println("Driver definition failed");
        	 }
        
        try 
        {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=IST","root","Aa123456");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.3.68/test","root","Root");
            System.out.println("SQL connection succeed");
            //createTableFlights(conn);
            
            //First method for updating one flight, 
            //updateArrivalTime(conn);
            
            // Second method for updating flights that come from paris and are scheduled before 15:00.
            // update_Arrival_Time_From_Parris_And_Arrives_Earlier_Than_3PM(conn);
            
            // Third part.
            printFlights(conn);

            Allow_User_To_Change_Flights_Arrival_Time_Manually(conn);
            
            
     	} catch (SQLException ex) 
     	    {/* handle any errors*/
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            }
   	}
	
	public static void printCourses(Connection con)
	{
		/*Statement stmt;
		try 
		{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM courses;");
	 		while(rs.next())
	 		{
				 // Print out the values
				 System.out.println(rs.getString(1)+"  " +rs.getString(2));
			} 
			rs.close();
			//stmt.executeUpdate("UPDATE course SET semestr=\"W08\" WHERE num=61309");
		} catch (SQLException e) {e.printStackTrace();}*/
	}

	
	public static void createTableCourses(Connection con1){
		Statement stmt;
		try {
			stmt = con1.createStatement();
			stmt.executeUpdate("create table courses(num int, name VARCHAR(40), semestr VARCHAR(10));");
			stmt.executeUpdate("load data local infile \"courses.txt\" into table courses");
	 		
		} catch (SQLException e) {	e.printStackTrace();}	 		
	}
	
	public static void createTableFlights(Connection con1) {
		Statement stmt;
		try {
			stmt = con1.createStatement();
			stmt.executeUpdate("create table Flights(Scheduled VARCHAR(255), Flight VARCHAR(255), `From` VARCHAR(255),"
					+ "Delay VARCHAR(255), Terminal VARCHAR(255));");
			stmt.executeUpdate("load data local infile \"arrived_flights.txt\" into table Flights");
	 		
		} catch (SQLException e) {	e.printStackTrace();}	 		
	}	
	
	public static void printFlights(Connection con)
	{
		Statement stmt;
		try 
		{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Flights;");
	 		while(rs.next())
	 		{
				 // Print out the values
				 System.out.println(rs.getString(1)+"  " +rs.getString(2));
			} 
			rs.close();
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	public static void updateArrivalTime(Connection con) 
		{
			Statement stmt;
			try 
			{
				stmt = con.createStatement();
				stmt.executeUpdate("Update Flights Set Scheduled = '12:30' Where Flight = 'KU101';");
			} catch (SQLException e) {e.printStackTrace();}
		}
	
	public static void update_Arrival_Time_From_Parris_And_Arrives_Earlier_Than_3PM(Connection con) 
	{
		Statement stmt;
		try 
		{
			stmt = con.createStatement();
			stmt.executeUpdate("Update Flights Set Scheduled = '00:00' Where `From` = 'Paris' AND Scheduled < '15:00';");
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	public static void Allow_User_To_Change_Flights_Arrival_Time_Manually(Connection con) throws SQLException {
		Statement statement = con.createStatement();
		ArrayList<String> flightNameArray = new ArrayList<>();
		ArrayList<String> scheduledFlightArray = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		
		ResultSet rs = statement.executeQuery("SELECT Flight FROM Flights;");
		
		printFlights(con);

		while (true) {
			System.out.println("Pick a flight number you want to change: ");
			flightNameArray.add(s.next()); // Add a flight name to the array.
			System.out.println("Pick a time in which the flight will depart: ");
			scheduledFlightArray.add(s.next());
		
			System.out.println("Do you want to change more flights: \nEnter 'q' to quit or 'y' to continue:");
			if (s.next().equals("q")) {
				break;
			}
		}
		
		// Insert update to the DB.
		PreparedStatement st = con.prepareStatement("Update Flights Set Scheduled = ? Where `Flight` = ?;");
		for (int i = 0; i < flightNameArray.size(); i++) {
			st.setString(1, scheduledFlightArray.get(i));
			st.setString(2, flightNameArray.get(i));
			
			st.executeUpdate();
		}
		
		s.close();
		statement.close();
	}
}

