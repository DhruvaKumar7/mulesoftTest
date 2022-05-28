package MovieDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;  
   
public class Select {  
	
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
   
  
    public void selectAll(String dbname,String tableName){  
    	Scanner scan = new Scanner(System.in);
        String sql = "SELECT * FROM " + tableName;
          
        try {  
            Connection conn = this.connect(dbname);  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
              while (rs.next()) {  
                System.out.println(rs.getInt("id") +  "\t" +   
                                   rs.getString("movName") + "\t" +
                                   rs.getString("actor") + "\t" +
                                   rs.getString("actress") + "\t" +
                                   rs.getString("director") + "\t" +
                                   rs.getInt("yor"));  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        
    }  
      
    public void select(String dbname,String tableName) {
    	Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Actor name : ");
    	String aname = scan.nextLine();
         try {
        	 String sql = "SELECT movName FROM "+tableName+" WHERE actor = ?";
             Connection conn = this.connect(dbname);  
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, aname);
             ResultSet rs    = ps.executeQuery();  
               
               while (rs.next()) {  
                 System.out.println(rs.getString("movName"));  
             }  
         } catch (SQLException e) {  
             System.out.println(e.getMessage());  
         }  
        
     }  
 }  
