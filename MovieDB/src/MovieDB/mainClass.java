package MovieDB;

import java.io.File;
import java.util.Scanner;

public class mainClass {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String dbname,tableName;
		while(true) {
		System.out.print("1:Create DataBase\n2:Create Table in DataBase\n3:Insert into Table\n4:Select from Table\n5:Exit\nEnter Choice : ");
		int ch = scanner.nextInt();
		switch(ch) {
		case 1:
			System.out.print("Enter the Database name : ");
			dbname = scanner.next();
			dbname = dbname+".db";
			CreateDB.createNewDatabase(dbname);
			break;
		case 2:
			System.out.print("Enter the Database name : ");
			dbname = scanner.next();
			dbname = dbname+".db";
			File file = new File("C:\\sqlite\\"+dbname);
			if(file.exists()) {
			System.out.print("Enter table name : ");
			tableName = scanner.next();
			CreateTable.createNewTable(dbname, tableName);
			} else {
				System.out.println("Database doesn't exist!");
			}
			break;
		case 3:
			System.out.print("Enter the Database name : ");
			dbname = scanner.next();
			dbname = dbname+".db";
			System.out.print("Enter table name : ");
			tableName = scanner.next();
			Insert input = new Insert();
			input.insert(dbname, tableName);
			break;
		case 4:
			System.out.print("Enter the Database name : ");
			dbname = scanner.next();
			dbname = dbname+".db";
			System.out.print("Enter table name : ");
			tableName = scanner.next();
			Select select = new Select();
			System.out.print("1:Select All movies \n2:Select movies based on actor \nEnter choice : ");
			int in = scanner.nextInt();
			switch(in) {
			case 1: select.selectAll(dbname, tableName);
			        break;
			case 2: select.select(dbname, tableName);
			        break;
			default: break;
		}
			break;
		default: return;
		}
	}
		
		
	}
}