package MovieDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;  
   
public class CreateTable {  
   
    public static void createNewTable(String dbname,String tableName) {  
    	
        String url = "jdbc:sqlite:C:\\sqlite\\"+dbname;  
          
          String sql = "CREATE TABLE IF NOT EXISTS "+tableName+"(\n"  
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"  
                + " movName text NOT NULL,\n"
                + " actor text NOT NULL,\n"
                + " actress text NOT NULL,\n"
                + " director text NOT NULL,\n"
                + "  yor integer NOT NULL\n"  
                + ");";  
          
        try{  
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            stmt.execute(sql);  
            System.out.println("Table Created Successfully.");
        } catch (SQLException e) {  
        	System.out.println(e.getMessage());  
            
        }  
   
    }
  }
  