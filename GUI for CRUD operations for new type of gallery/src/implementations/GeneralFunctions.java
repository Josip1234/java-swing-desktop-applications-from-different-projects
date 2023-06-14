package implementations;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entities.DatabaseConnection;
import entities.DatabaseMessages;
import entities.File;
import entities.FileMessages;

public class GeneralFunctions {
   
	public static void initApp() {
		boolean doesFileExists=false;
		DatabaseConnection connection = new DatabaseConnection();
		File file = new File();
	    FileImplementation fileImplementation = new FileImplementation();
	    doesFileExists=fileImplementation.checkIfFileExists(file);
	    if(doesFileExists==true) {
	    	System.out.println(FileMessages.readingFromFile);
	    	String value=fileImplementation.readFromAFile(file);
	        System.out.println(value);
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
				        setVisible(frame, true);
				        showDialog(frame, DatabaseMessages.driverRegistered);
				 	   setVisible(frame, false);
				}else if(message.contentEquals(DatabaseMessages.databaseIsConnected)) {
					  JFrame frame = createJFrame(name);
				        setVisible(frame, true);
				        showDialog(frame, DatabaseMessages.databaseIsConnected);
				 	   setVisible(frame, false);
				}else if(message.contentEquals(DatabaseMessages.closingConnection)) {
					  JFrame frame = createJFrame(name);
				        setVisible(frame, true);
				        showDialog(frame, DatabaseMessages.closingConnection);
				 	   setVisible(frame, false);
				}else if(message.contentEquals(DatabaseMessages.conectionClosed)) {
					  JFrame frame = createJFrame(name);
				        setVisible(frame, true);
				        showDialog(frame, DatabaseMessages.conectionClosed);
				 	   setVisible(frame, false);
				}
			}else if(object instanceof FileMessages) {
				if(message.contentEquals(FileMessages.writingToAFile)) {
					  JFrame frame = createJFrame(name);
				        setVisible(frame, true);
				        showDialog(frame, FileMessages.writingToAFile);
				 	   setVisible(frame, false);
				}else if(message.contentEquals(FileMessages.finishedWriting)) {
					  JFrame frame = createJFrame(name);
				        setVisible(frame, true);
				        showDialog(frame, FileMessages.finishedWriting);
				 	   setVisible(frame, false);
				}else if(message.contentEquals(FileMessages.readingFromFile)) {
					  JFrame frame = createJFrame(name);
				        setVisible(frame, true);
				        showDialog(frame, FileMessages.readingFromFile);
				 	   setVisible(frame, false);
				}else if(message.contentEquals(FileMessages.finishedReading)) {
					  JFrame frame = createJFrame(name);
				        setVisible(frame, true);
				        showDialog(frame, FileMessages.finishedReading);
				 	   setVisible(frame, false);
				}
			}
		}else if(name.contentEquals("Error")) {
			if(object instanceof DatabaseMessages) {
				if(message.contentEquals(DatabaseMessages.driverNotRegistered)) {
					  JFrame frame = createJFrame(name);
					   setVisible(frame, true);
					   showErrorDialog(frame, DatabaseMessages.driverNotRegistered);
					   setVisible(frame, false);
				}else if(message.contentEquals(DatabaseMessages.failedToConnectToDatabase)) {
					  JFrame frame = createJFrame(name);
					   setVisible(frame, true);
					   showErrorDialog(frame, DatabaseMessages.failedToConnectToDatabase);
					   setVisible(frame, false);
				}else if(message.contentEquals(DatabaseMessages.problemClosingConnection)) {
					  JFrame frame = createJFrame(name);
					   setVisible(frame, true);
					   showErrorDialog(frame, DatabaseMessages.problemClosingConnection);
					   setVisible(frame, false);
				}
			}else if(object instanceof FileMessages) {
				if(message.contentEquals( FileMessages.errorOpeningTheFiles)) {
					  JFrame frame = createJFrame(name);
					   setVisible(frame, true);
					   showErrorDialog(frame, FileMessages.errorOpeningTheFiles);
					   setVisible(frame, false);
				}else if(message.contentEquals(FileMessages.fileNotFound)) {
					  JFrame frame = createJFrame(name);
					   setVisible(frame, true);
					   showErrorDialog(frame, FileMessages.fileNotFound);
					   setVisible(frame, false);
				}else if(message.contains(FileMessages.fieldNotExists)) {
					  JFrame frame = createJFrame(name);
					   setVisible(frame, true);
					   showErrorDialog(frame, FileMessages.fieldNotExists);
					   setVisible(frame, false);
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
}
