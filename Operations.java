package Mulesoft;
import java.util.Scanner;

import java.sql.*;

class Operations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String flag="Yes";

		do{

		System.out.println("Select DML Operation For Table.. ");

		System.out.println("1. Insert data in the table");

		System.out.println("2. Select ALL data from the table");
		
		System.out.println("3. Select data with parameter Actor_Name from the table");

		System.out.println("4. Exit the database");

		Scanner reader = new Scanner(System.in);

		System.out.println("Enter a choice: ");

		int n = reader.nextInt();

		Connection c = null;

		Statement stmt = null;

		try {

		Class.forName("org.sqlite.JDBC");

		c = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\MOVIES.db");
		
		c.setAutoCommit(false);

		stmt = c.createStatement();

		String Movie_Name ="", sql="";

		String Lead_Actor = ""; 
		
		String Lead_Actress = ""; 
		
		String Dir_Name = ""; 
		
		String Year_of_Release= ""; 
		
		int id;

		Scanner scanName;

		switch(n){
 
		case 1:

			scanName=new Scanner(System.in);
	
			System.out.println("Enter movie Name:");
	
			Movie_Name=scanName.nextLine();
	
			System.out.println("Enter lead actor");
	
			Lead_Actor=scanName.nextLine();
			
			System.out.println("Enter lead actress:");
	
	        Lead_Actress=scanName.nextLine();
	        
	        System.out.println("Enter Director:");
	
	        Dir_Name =scanName.nextLine();
	        
	        System.out.println("Enter Release year:");
	
	        Year_of_Release =scanName.nextLine();
	
			sql = "INSERT INTO DATABASE_MOVIE (Movie_Name,Lead_Actor,Lead_Actress,Dir_Name,Year_of_Release) " +
	
			"VALUES ('" + Movie_Name+ "','" + Lead_Actor + "','" + Lead_Actress +  "','" + Dir_Name + "','" + Year_of_Release + "'" + ")";
	
			stmt.executeUpdate(sql);
	
			System.out.println("Inserted Successfully!");
	
			break;

		 
		case 2:

			ResultSet rs = stmt.executeQuery("SELECT * FROM DATABASE_MOVIE;");
	
			System.out.println("ID\t\tMovie_Name\t\tLead_Actor\t\tLead_Actress\t\tDir_Name\t\tYear_of_Release");
			
			while ( rs.next() ) {
	
			id = rs.getInt("p_id");
	
			Movie_Name = rs.getString("Movie_Name");
	
			Lead_Actor = rs.getString("Lead_Actor");
	
			Lead_Actress = rs.getString("Lead_Actress");
			
			Dir_Name = rs.getString("Dir_Name");
			
			Year_of_Release = rs.getString("Year_of_Release");
	
			System.out.println(id+"\t\t"+Movie_Name+"\t\t"+Lead_Actor+"\t\t"+Lead_Actress+"\t\t"+Dir_Name+"\t\t"+Year_of_Release);
	
			}
	
			rs.close();
	
			break;
	 

		
		case 3:
			scanName = new Scanner(System.in);
			
			System.out.println("Enter actor name: ");
			
			String ask = scanName.next();
			
			sql = "Select Movie_Name from DATABASE_MOVIE where Lead_Actor = " + ask + ";";
			
			ResultSet r = stmt.executeQuery(sql);
			
			System.out.println("List of movies in which" + ask + "acted : ");
			
			System.out.println("Movies are: ");
			
			while(r.next())
			{
				Movie_Name = r.getString("Movie_Name");
				
				System.out.println(Movie_Name);
			}
			
			r.close();
			
			break;
			
			
		case 4:

			System.exit(0);

			break;

		 
		default:

			System.out.println("Oops! Invalid Choice.");
	
			break;

		}

		stmt.close();

		c.commit();

		c.close();

		}

		catch ( Exception e )

		{

		System.err.println( e.getClass().getName() + ": " + e.getMessage() );

		System.exit(0);

		}

		 

		System.out.println("Continue Yes OR No?");

		reader=new Scanner(System.in);

		flag=reader.nextLine();

		 

		}while(flag.equalsIgnoreCase("Yes"));

		System.exit(0);

		}
	}