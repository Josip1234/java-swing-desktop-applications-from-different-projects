package implementations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
				  JFrame frame = new JFrame("Error");
           	   frame.setVisible(true);
           	JOptionPane.showMessageDialog(frame,
           		    DatabaseMessages.problemClosingConnection,
           		    "Error",
           		    JOptionPane.ERROR_MESSAGE);
			}
           }
		   if (statement != null) {
               try {
            	   JFrame frame = new JFrame("Info");
            	   frame.setVisible(true);
            	   JOptionPane.showMessageDialog(frame,
            			    DatabaseMessages.closingConnection);
            	   frame.setVisible(false);
				con.close();
				   frame = new JFrame("Info");
            	   frame.setVisible(true);
            	   JOptionPane.showMessageDialog(frame,
            			    DatabaseMessages.conectionClosed);
            	   frame.setVisible(false);
			
			} catch (SQLException e) {
				  JFrame frame = new JFrame("Error");
	           	   frame.setVisible(true);
	           	JOptionPane.showMessageDialog(frame,
	           		    DatabaseMessages.problemClosingConnection,
	           		    "Error",
	           		    JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
           }
		return con;
	}

}
