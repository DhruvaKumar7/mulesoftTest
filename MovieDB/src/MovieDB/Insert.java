package MovieDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;  
   
public class Insert {  
   
    private Connection connect(String dbname) {  
        String url = "jdbc:sqlite:C:\\sqlite\\"+dbname;  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    }  
   
  
    public void insert(String dbname,String tableName ) { 
    	
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter the Movie name, Actor, Actress, Director, Year of Release : ");
    	String mname = scan.nextLine();
    	String act = scan.nextLine();
    	String actr = scan.nextLine();
    	String dir = scan.nextLine();
    	int y = scan.nextInt();
        String sql = "INSERT INTO "+tableName+"(movName,actor,actress,director,yor) VALUES(?,?,?,?,?)";  
   
        try{  
            Connection conn = this.connect(dbname);  
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, mname);  
            pstmt.setString(2, act);
            pstmt.setString(3, actr);
            pstmt.setString(4, dir);
            pstmt.setInt(5, y);
            pstmt.executeUpdate();  
            System.out.println("1 Record Inserted Successfully.");
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        
    }  
        

}