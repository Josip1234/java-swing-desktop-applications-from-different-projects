package implementations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import entities.DatabaseConnection;
import entities.DatabaseMessages;
import interfaces.DatabaseInterface;

public class DatabaseImpl implements DatabaseInterface {
	

	public DatabaseImpl() {
	
	}

	@Override
	public Connection openConnection(DatabaseConnection connection, Connection conn, Statement stmt) {
	
        System.out.println(DatabaseMessages.connecting);
        try {
			Class.forName(connection.getJDBC_DRIVER());
			System.out.println(DatabaseMessages.driverRegistered);
		
		} catch (ClassNotFoundException e) {
		System.out.println(DatabaseMessages.driverNotRegistered);
			e.printStackTrace();
		}

      

        try {
			conn = DriverManager.getConnection(
			        connection.getDB_URL(), connection.getUSER(), connection.getPASS());
		
		    System.out.println(DatabaseMessages.databaseIsConnected);
		} catch (SQLException e) {
	System.out.println(DatabaseMessages.failedToConnectToDatabase);
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
				con.close();
		
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
           }
		   if (statement != null) {
               try {
				con.close();
			
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
           }
		return con;
	}

}
