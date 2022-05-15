package Mulesoft;
import java.sql.*;
public class Table {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection c = null;

		Statement stmt = null;

		try {

		Class.forName("org.sqlite.JDBC");

		c = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\MOVIES.db");

		System.out.println("Database Opened...\n");

		stmt = c.createStatement();

		String sql = "CREATE TABLE DATABASE_MOVIE" +

		"(p_id INTEGER PRIMARY KEY AUTOINCREMENT," +

		" Movie_Name TEXT NOT NULL, " +

		" Lead_Actor TEXT NOT NULL, " +

		" Lead_Actress TEXT NOT NULL, " +
		
		" Dir_Name TEXT NOT NULL," + 
		
		" Year_of_Release TEXT NOT NULL)" ;
		

		stmt.executeUpdate(sql);

		stmt.close();

		c.close();

		}

		catch ( Exception e ) {

		System.err.println( e.getClass().getName() + ": " + e.getMessage() );

		System.exit(0);

		}

		System.out.println("Table DATABASE_MOVIE Created Successfully!");

		}

	}