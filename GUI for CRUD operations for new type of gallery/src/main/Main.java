package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entities.DatabaseConnection;
import entities.DatabaseMessages;
import entities.DbQuery;
import entities.File;
import entities.FileMessages;
import entities.Tables;
import implementations.DatabaseImpl;
import implementations.FileImplementation;
import implementations.GeneralFunctions;

public class Main {

	public static void main(String[] args) throws SQLException {
		//first use
	       // DatabaseConnection connection = new DatabaseConnection("org.mariadb.jdbc.Driver", "jdbc:mariadb://localhost/test", "root", "");
	       // System.out.println(connection); 

           // String sql = "CREATE TABLE REGISTRATION "
             //       + "(id INTEGER not NULL, "
             //       + " first VARCHAR(255), "
             //       + " last VARCHAR(255), "
             //       + " age INTEGER, "
             //       + " PRIMARY KEY ( id ))";
                 /*  conn=databaseImpl.openConnection(connection, conn, stmt);
                   databaseImpl.insertIntoDatabase(stmt, sql, conn);
                   conn=databaseImpl.closeConnection(stmt, conn);
		*/
		       // System.out.println(connection);
	
	        
	        //second use
	      
	        //third use
		//FileMessages messages = new FileMessages();
		//GeneralFunctions.showMessages("Error",messages,  FileMessages.fieldNotExists);
     
	   
			 DatabaseConnection con = new DatabaseConnection();
		     con.setDB_URL("jdbc:mariadb://localhost/basicwebsite");
		     DatabaseImpl databaseImpl = new DatabaseImpl();
		      Statement stmt=null;
			Connection connection = databaseImpl.openConnection(con, null, stmt);
			stmt = connection.createStatement();
			   DbQuery dbQuery = new DbQuery("Show tables");
               List<Tables> tab=databaseImpl.returnListOfTables(con, databaseImpl, stmt, connection, dbQuery);
               System.out.println(tab.toString());

	  

	}


}
