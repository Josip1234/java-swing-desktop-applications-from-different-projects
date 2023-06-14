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
	        JFrame frame = new JFrame("Info");
	        frame.setVisible(true);
	        JOptionPane.showMessageDialog(frame,
	        		DatabaseMessages.driverRegistered);
	 	   frame.setVisible(false);
		
		} catch (ClassNotFoundException e) {
			   JFrame frame = new JFrame("Error");
			   frame.setVisible(true);
			JOptionPane.showMessageDialog(frame,
					DatabaseMessages.driverNotRegistered,
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			   frame.setVisible(false);
			e.printStackTrace();
		}

      

        try {
			conn = DriverManager.getConnection(
			        connection.getDB_URL(), connection.getUSER(), connection.getPASS());
	        JFrame frame = new JFrame("Info");
	        frame.setVisible(true);
	        JOptionPane.showMessageDialog(frame,
	        		DatabaseMessages.databaseIsConnected);
	 	   frame.setVisible(false);
		} catch (SQLException e) {
			  JFrame frame = new JFrame("Error");
			   frame.setVisible(true);
			JOptionPane.showMessageDialog(frame,
					DatabaseMessages.failedToConnectToDatabase,
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			   frame.setVisible(false);
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
