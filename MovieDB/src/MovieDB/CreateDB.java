package MovieDB;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;  

public class CreateDB {
	
	    public static void createNewDatabase(String fileName)  { 
	    	File file = new File("C:\\sqlite\\"+fileName);
	        if(file.exists()) {
	        	System.out.println("This Database already exists!!");
	        }
	        else {	
	        String url = "jdbc:sqlite:C:\\sqlite\\" + fileName;  
	   
	        try {  
	            Connection conn = DriverManager.getConnection(url);  
	            if (conn != null) {  
	                DatabaseMetaData meta = conn.getMetaData();  
	                System.out.println("The driver name is " + meta.getDriverName());  
	                System.out.println("A new database has been created.");  
	            }  
	   
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	    }  
	}
	   
}  

