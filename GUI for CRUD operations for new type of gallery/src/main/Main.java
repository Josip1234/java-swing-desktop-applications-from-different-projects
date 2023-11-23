package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import entities.Columns;
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
		     con.setDB_URL("jdbc:mariadb://localhost/dynamic_gallery");
		     DatabaseImpl databaseImpl = new DatabaseImpl();
		      Statement stmt=null;
			Connection connection = databaseImpl.openConnection(con, null, stmt);
			stmt = connection.createStatement();
			   DbQuery dbQuery = new DbQuery("Show tables");
               List<Tables> tab=databaseImpl.returnListOfTables(con, databaseImpl, stmt, connection, dbQuery);
               //System.out.println(tab.toString());
               //System.out.println("Show table columns and data types");
               Tables tables = new Tables("storage_system");
               List<Columns> columns = databaseImpl.readColumnsFromTable(con, connection, stmt, tables, databaseImpl);
               //System.out.println(columns.toString());
               //after table has been chosen, read all data from it
               List<String> data = databaseImpl.returnAllDataFromTable(con, databaseImpl, stmt, connection, dbQuery, tables, columns);
               //System.out.println(data.toString());
               Map<String,String> map = new HashMap<String,String>();
               
               int index=0;
               for (String string : data) {
            	   
            	   System.out.println(columns.get(index).getColumnName()+" "+string); // ovo dodavati u podlistu ili polje, bolje povezati objekte recimo naziv stupca sa re
            	  
				   if(string.contentEquals("-")) {
					   
					   break;
				   }
				   index++;
			}
         
         
			}
            
	  

	}

