package implementations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entities.DatabaseConnection;
import entities.DatabaseMessages;
import entities.DbQuery;
import entities.Tables;
import interfaces.DatabaseInterface;
import interfaces.SelectQuery;

public class DatabaseImpl implements DatabaseInterface,SelectQuery  {
	

	public DatabaseImpl() {
	
	}

	@Override
	public Connection openConnection(DatabaseConnection connection, Connection conn, Statement stmt) {
	
        System.out.println(DatabaseMessages.connecting);
        try {
			Class.forName(connection.getJDBC_DRIVER());
			DatabaseMessages messages = new DatabaseMessages();
			GeneralFunctions.showMessages("Info",messages, DatabaseMessages.driverRegistered);
		} catch (ClassNotFoundException e) {
			DatabaseMessages messages = new DatabaseMessages();
			GeneralFunctions.showMessages("Error",messages, DatabaseMessages.driverNotRegistered);
			e.printStackTrace();
		}

      

        try {
			conn = DriverManager.getConnection(
			        connection.getDB_URL(), connection.getUSER(), connection.getPASS());
			DatabaseMessages messages = new DatabaseMessages();
			GeneralFunctions.showMessages("Info",messages, DatabaseMessages.databaseIsConnected);
		} catch (SQLException e) {
			DatabaseMessages messages = new DatabaseMessages();
			GeneralFunctions.showMessages("Error",messages, DatabaseMessages.failedToConnectToDatabase);
			e.printStackTrace();
		}
    
		return conn;
	}

	@Override
	public boolean insertIntoDatabase(Statement statement, String query,Connection con) {
		boolean done=false;
		try {
			statement = con.createStatement();
			done=true;
			System.out.println(DatabaseMessages.databaseInsertWasSuccessfull);
		} catch (SQLException e1) {
			done=false;
			System.out.println(DatabaseMessages.failedToInsertData);
			e1.printStackTrace();
		}

		try {
			statement.executeUpdate(query);
			done=true;
			System.out.println(DatabaseMessages.databaseInsertWasSuccessfull);
		} catch (SQLException e) {
			done=false;
			System.out.println(DatabaseMessages.failedToInsertData);
			e.printStackTrace();
		}
		return done;
	}

	@Override
	public Connection closeConnection(Statement statement, Connection con) {
	
		   if (statement != null) {
               try {
           		DatabaseMessages messages = new DatabaseMessages();
        		GeneralFunctions.showMessages("Info",messages, DatabaseMessages.closingConnection);
				con.close();
				messages = new DatabaseMessages();
				GeneralFunctions.showMessages("Info",messages,  DatabaseMessages.conectionClosed);
		
			} catch (SQLException e) {
				DatabaseMessages messages = new DatabaseMessages();
				GeneralFunctions.showMessages("Error",messages,  DatabaseMessages.problemClosingConnection);
			}
           }
		   if (statement != null) {
               try {
            		DatabaseMessages messages = new DatabaseMessages();
            		GeneralFunctions.showMessages("Info",messages,  DatabaseMessages.closingConnection);
				con.close();
				messages = new DatabaseMessages();
				GeneralFunctions.showMessages("Info",messages,  DatabaseMessages.conectionClosed);
			
			} catch (SQLException e) {
				DatabaseMessages messages = new DatabaseMessages();
				GeneralFunctions.showMessages("Error",messages,  DatabaseMessages.problemClosingConnection);
				e.printStackTrace();
			}
           }
		return con;
	}

	@Override
	public List<Object> returnList(Statement statement, DbQuery dbQuery) throws SQLException {
		List<Object> list = new ArrayList<Object>();
	    ResultSet rs= statement.executeQuery(dbQuery.getQuery());
	    while(rs.next()) {
	    	
	    	list.add(rs.getString(1));
	    }
		return list;
	}

	@Override
	public List<Tables> returnListOfTables(DatabaseConnection con, DatabaseImpl databaseImpl, Statement stm,
			Connection connection, DbQuery dbQuery) throws SQLException {
		  List<Object> list = new ArrayList<Object>();
		   List<Tables> tables = new ArrayList<Tables>();
			list=databaseImpl.returnList(stm, dbQuery);
			
			for (Object object : list) {
				//System.out.println("Object:"+object);
				tables.add(new Tables(object.toString()));
			}
			return tables;
	}



}
