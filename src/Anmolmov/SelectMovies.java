package Anmolmov;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;
import java.util.Scanner;

public class SelectMovies {

	private Connection connect() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:/C:\\java\\sqlite-tools-win32-x86-3390300\\sqlite-tools-win32-x86-3390300\\moviesdb.db";  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    }  
   
  
    public void selectAll(){  
        String sql = "SELECT * FROM Movies";  
          
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            System.out.println("movid\tmoviename\t\tactor\t\tactress\t\tdirector\tyearofrelease");
            while (rs.next()) {  
                System.out.println(rs.getInt("movid") +  "\t" +   
                                   rs.getString("name") + "\t" +  
                                   rs.getString("actor") + "\t" + 
                                   rs.getString("actress") + "\t" + 
                                   rs.getString("director") + "\t" + 
                                   rs.getInt("yearofrelease"));  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
    
    
    public void selectActor(String actorName){  
        String sql = "SELECT * FROM Movies WHERE actor = ?";  
          
        try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,actorName);
            
            ResultSet rs    = pstmt.executeQuery();  
              
            System.out.println("movid\tmoviename\t\tactor\t\tactress\t\tdirector\tyearofrelease");
            while (rs.next()) {  
                System.out.println(rs.getInt("movid") +  "\t" +   
                                   rs.getString("name") + "\t" +  
                                   rs.getString("actor") + "\t" + 
                                   rs.getString("actress") + "\t" + 
                                   rs.getString("director") + "\t" + 
                                   rs.getInt("yearofrelease"));  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }
    
    
    public void selectDirector(String director){  
        String sql = "SELECT * FROM Movies WHERE director = ?";  
          
        try {  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,director);
            
            ResultSet rs    = pstmt.executeQuery();  
              
            System.out.println("movid\tmoviename\tactor\tactress\tdirector\tyearofrelease");
            while (rs.next()) {  
                System.out.println(rs.getInt("movid") +  "\t" +   
                                   rs.getString("name") + "\t" +  
                                   rs.getString("actor") + "\t" + 
                                   rs.getString("actress") + "\t" + 
                                   rs.getString("director") + "\t" + 
                                   rs.getInt("yearofrelease"));  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    } 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SelectMovies mov = new SelectMovies();
			System.out.println("All entries\n");
	        mov.selectAll();
	        
	        System.out.println("\nAccording to actor name\nEnter actor name\n");
	        String actorName = sc.nextLine();
	        mov.selectActor(actorName);
	        
	        System.out.println("\nAccording to Director name\nEnter director name\n");
	        String directorName = sc.nextLine();
	        mov.selectDirector(directorName);
	        
	}

}
