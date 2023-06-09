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
	
	       //STEP 2: Register JDBC driver
        try {
			Class.forName(connection.getJDBC_DRIVER());
		
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}

        //STEP 3: Open a connection
      
        System.out.println(DatabaseMessages.connecting);
        try {
			conn = DriverManager.getConnection(
			        connection.getDB_URL(), connection.getUSER(), connection.getPASS());
		
		    System.out.println(DatabaseMessages.databaseIsConnected);
		} catch (SQLException e) {
	
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
		} catch (SQLException e1) {
			done=false;
			e1.printStackTrace();
		}

		try {
			statement.executeUpdate(query);
			done=true;
		} catch (SQLException e) {
			done=false;
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
