package Mulesoft;
import java.sql.*;

public class Mule_assignment
{
	public static void main( String args[] )
	{
		Connection c = null;
		
		try 
		{		
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\MOVIES.db");
		}
		
		catch ( Exception e ) 
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);	
		}
		
		System.out.println("database successfully created");
		
	}
}
