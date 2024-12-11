import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class mysqlConnection {

	private static Connection conn;
	
	public void connectToDB() 
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
             conn = DriverManager.getConnection("jdbc:mysql://localhost/clientserver?serverTimezone=IST","root","Rk123456");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.3.68/test","root","Root");
            System.out.println("SQL connection succeed");
            //createTableCourses(conn);
            printCourses(conn);
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

	
//	public static void createTableCourses(Connection con1){
//		Statement stmt;
//		try {
//			stmt = con1.createStatement();
//			stmt.executeUpdate("create table courses(num int, name VARCHAR(40), semestr VARCHAR(10));");
//			stmt.executeUpdate("load data local infile \"courses.txt\" into table courses");
//	 		
//		} catch (SQLException e) {	e.printStackTrace();}
//		 		
//	}
	
	
	public static void insertToDB(ArrayList<String> arr) throws SQLException {
		
		PreparedStatement pr =  conn.prepareStatement("insert into costumers(UserName, ID, Department, Tel) Values(?,?,?,?)");
	
		pr.setString(1, arr.get(0));
		pr.setString(2, arr.get(1));
		pr.setString(3, arr.get(2));
		pr.setString(4, arr.get(3));
		pr.executeUpdate();
	}
}


