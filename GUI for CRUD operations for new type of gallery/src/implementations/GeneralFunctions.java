package implementations;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entities.DatabaseConnection;
import entities.DatabaseMessages;
import entities.DbQuery;
import entities.File;
import entities.FileMessages;
import entities.Tables;

public class GeneralFunctions {
   
	public static void initApp() {
		boolean doesFileExists=false;
		DatabaseConnection connection = new DatabaseConnection();
		File file = new File();
	    FileImplementation fileImplementation = new FileImplementation();
	    doesFileExists=fileImplementation.checkIfFileExists(file);
	    if(doesFileExists==true) {
	    	//System.out.println(FileMessages.readingFromFile);
	    	String value=fileImplementation.readFromAFile(file);
	        //System.out.println(value);
	    	//stavi u text field
	    
	    }else {
	     
            
            System.out.println(FileMessages.writingToAFile);
	        fileImplementation.writeToAFile(file, connection);
	    	
	    }
	}
	public static void showMessages(String name, Object object, String message) {
		if(name.contentEquals("Info")) {
			if(object instanceof DatabaseMessages) {
				if(message.contentEquals(DatabaseMessages.driverRegistered)) {
					  JFrame frame = createJFrame(name);
				      
				        showDialog(frame, DatabaseMessages.driverRegistered);
				 	   
				}else if(message.contentEquals(DatabaseMessages.databaseIsConnected)) {
					  JFrame frame = createJFrame(name);
				      
				        showDialog(frame, DatabaseMessages.databaseIsConnected);
				 	   
				}else if(message.contentEquals(DatabaseMessages.closingConnection)) {
					  JFrame frame = createJFrame(name);
				      
				        showDialog(frame, DatabaseMessages.closingConnection);
				 	   
				}else if(message.contentEquals(DatabaseMessages.conectionClosed)) {
					  JFrame frame = createJFrame(name);
				      
				        showDialog(frame, DatabaseMessages.conectionClosed);
				 	   
				}
			}else if(object instanceof FileMessages) {
				if(message.contentEquals(FileMessages.writingToAFile)) {
					  JFrame frame = createJFrame(name);
				      
				        showDialog(frame, FileMessages.writingToAFile);
				 	   
				}else if(message.contentEquals(FileMessages.finishedWriting)) {
					  JFrame frame = createJFrame(name);
				      
				        showDialog(frame, FileMessages.finishedWriting);
				 	   
				}else if(message.contentEquals(FileMessages.readingFromFile)) {
					  JFrame frame = createJFrame(name);
				      
				        showDialog(frame, FileMessages.readingFromFile);
				 	   
				}else if(message.contentEquals(FileMessages.finishedReading)) {
					  JFrame frame = createJFrame(name);
				      
				        showDialog(frame, FileMessages.finishedReading);
				 	   
				}
			}
		}else if(name.contentEquals("Error")) {
			if(object instanceof DatabaseMessages) {
				if(message.contentEquals(DatabaseMessages.driverNotRegistered)) {
					  JFrame frame = createJFrame(name);
					 
					   showErrorDialog(frame, DatabaseMessages.driverNotRegistered);
					   
				}else if(message.contentEquals(DatabaseMessages.failedToConnectToDatabase)) {
					  JFrame frame = createJFrame(name);
					 
					   showErrorDialog(frame, DatabaseMessages.failedToConnectToDatabase);
					   
				}else if(message.contentEquals(DatabaseMessages.problemClosingConnection)) {
					  JFrame frame = createJFrame(name);
					 
					   showErrorDialog(frame, DatabaseMessages.problemClosingConnection);
					   
				}
			}else if(object instanceof FileMessages) {
				if(message.contentEquals( FileMessages.errorOpeningTheFiles)) {
					  JFrame frame = createJFrame(name);
					 
					   showErrorDialog(frame, FileMessages.errorOpeningTheFiles);
					   
				}else if(message.contentEquals(FileMessages.fileNotFound)) {
					  JFrame frame = createJFrame(name);
					 
					   showErrorDialog(frame, FileMessages.fileNotFound);
					   
				}else if(message.contains(FileMessages.fieldNotExists)) {
					  JFrame frame = createJFrame(name);
					 
					   showErrorDialog(frame, FileMessages.fieldNotExists);
					   
				}
			}
		}
	   
	
	}
	
	public static JFrame createJFrame(String name) {
		return new JFrame(name);
	}
	
	public static void setVisible(JFrame frame, boolean value) {
		boolean visible=false;
		if(value==true) {
			visible=true;
		}else {
			visible=false;
		}
		frame.setVisible(visible);
	}
	public static void showDialog(JFrame frame, String message) {
	     JOptionPane.showMessageDialog(frame,
	        		message);
	}
	public static void showErrorDialog(JFrame frame, String message) {
		JOptionPane.showMessageDialog(frame,
				message,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}
	public static List<Tables> getListOfTables(FileImplementation fileImplementation, File file, Connection connection, Statement statement, DatabaseConnection con, DatabaseImpl databaseImpl, DbQuery dbQuery) throws SQLException{
		List<Tables> tables = new ArrayList<Tables>();

		String valueToParse=fileImplementation.readFromAFile(file);

		con.setDB_URL(fileImplementation.parse(valueToParse, "DB_URL"));
		
   
		connection = databaseImpl.openConnection(con, null, statement);
		statement=connection.createStatement();
		List<Tables> list=databaseImpl.returnListOfTables(con, databaseImpl, statement, connection, dbQuery);
		connection=databaseImpl.closeConnection(statement, connection);
		tables=list;
		return tables;
	}
}
