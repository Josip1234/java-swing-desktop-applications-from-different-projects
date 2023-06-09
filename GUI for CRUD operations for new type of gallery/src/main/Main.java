package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import entities.DatabaseConnection;
import entities.DatabaseMessages;
import entities.File;
import implementations.DatabaseImpl;
import implementations.FileImplementation;

public class Main {

	public static void main(String[] args) {
		//first use
	        DatabaseConnection connection = new DatabaseConnection("org.mariadb.jdbc.Driver", "jdbc:mariadb://localhost/test", "root", "");
	        System.out.println(connection); 
	        Connection conn = null;
	        Statement stmt = null;
            DatabaseImpl databaseImpl = new DatabaseImpl();
            String sql = "CREATE TABLE REGISTRATION "
                    + "(id INTEGER not NULL, "
                    + " first VARCHAR(255), "
                    + " last VARCHAR(255), "
                    + " age INTEGER, "
                    + " PRIMARY KEY ( id ))";
                   conn=databaseImpl.openConnection(connection, conn, stmt);
                   databaseImpl.insertIntoDatabase(stmt, sql, conn);
                   conn=databaseImpl.closeConnection(stmt, conn);
		
		        System.out.println(connection);
	
	        
	        //second use
	        File file = new File();
	        FileImplementation fileImplementation = new FileImplementation();
	        fileImplementation.writeToAFile(file, connection);
	        //third use
	        fileImplementation.readFromAFile(file);

	}

}
