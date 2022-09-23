package Anmolmov;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.sql.Statement; 


public class CreateMovieTable {
  
		   
	    public static void createMovTable() {  
 
	        String url = "jdbc:sqlite:/C:\\java\\sqlite-tools-win32-x86-3390300\\sqlite-tools-win32-x86-3390300\\moviesdb.db";  
	           
	        String sql = "CREATE TABLE IF NOT EXISTS Movies (\n"  
	        		+ " movid integer PRIMARY KEY,\n" 
	                + " name text NOT NULL,\n"  
	                + " actor text NOT NULL,\n"
	                + " actress text NOT NULL,\n"
	                + " director text NOT NULL,\n" 
	                + " yearofrelease integer NOT NULL\n"  
	                + ");";  
	          
	        try{  
	            Connection conn = DriverManager.getConnection(url);  
	            Statement stmt = conn.createStatement();  
	            stmt.execute(sql);  
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	    }  
	
	
	
	public static void main(String[] args) {
		
		createMovTable();
	}

	
}
