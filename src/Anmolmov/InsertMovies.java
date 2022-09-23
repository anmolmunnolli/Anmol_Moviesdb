package Anmolmov;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  

public class InsertMovies {

	private Connection connect() {  
  
        String url = "jdbc:sqlite:/C:\\java\\sqlite-tools-win32-x86-3390300\\sqlite-tools-win32-x86-3390300\\moviesdb.db";  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    }  
   
  
    public void insert(String name, String actor, String actress, String director, Integer yearofrelease) {  
        String sql = "INSERT INTO Movies(name, actor, actress, director, yearofrelease) VALUES(?,?,?,?,?)";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, name);
            pstmt.setString(2, actor);
            pstmt.setString(3, actress);
            pstmt.setString(4, director);
            pstmt.setInt(5,yearofrelease);  
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
	
	
	public static void main(String[] args) {
		InsertMovies mov = new InsertMovies(); 
		
		mov.insert("Interstellar", "Matthew McConaughey", "Anne Hathaway", "Christopher Nolan", 2014);
		mov.insert("Inception", "Leonardo DiCaprio", "Marion Cotillard", "Christopher Nolan", 2010);
		mov.insert("Joker", "Joaquin Phoenix", "Zazie Beetz", "Todd Phillips", 2019);
		mov.insert("Thor: Love and Thunder", "Chris Hemsworth", "Natalie Portman", "Taika Waititi", 2022);
		mov.insert("A Beautiful Mind", "Russell Crowe", "Jennifer Connelly", "Ron Howard", 2001);
		
		

	}

}
