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
				}
			}
		}
	   
	 	   
	 /*	   
    	   
    	   
    	   JFrame frame = new JFrame("Error");
       	   frame.setVisible(true);
       	JOptionPane.showMessageDialog(frame,
       		    DatabaseMessages.problemClosingConnection,
       		    "Error",
       		    JOptionPane.ERROR_MESSAGE);
       	
        JFrame frame = new JFrame("Info");
 	   frame.setVisible(true);
 	   JOptionPane.showMessageDialog(frame,
 			    DatabaseMessages.closingConnection);
 	   frame.setVisible(false);
 	   
 	   frame = new JFrame("Info");
	   frame.setVisible(true);
	   JOptionPane.showMessageDialog(frame,
			    DatabaseMessages.conectionClosed);
	   frame.setVisible(false);
	   
	   JFrame frame = new JFrame("Error");
   	   frame.setVisible(true);
   	JOptionPane.showMessageDialog(frame,
   		    DatabaseMessages.problemClosingConnection,
   		    "Error",
   		    JOptionPane.ERROR_MESSAGE);
   	
	JFrame frame = new JFrame("Info");
	frame.setVisible(true);
	JOptionPane.showMessageDialog(frame,
		    FileMessages.writingToAFile);
	frame.setVisible(false);
	
	frame = new JFrame("Info");
	frame.setVisible(true);
	JOptionPane.showMessageDialog(frame,
		    FileMessages.finishedWriting);
	frame.setVisible(false);
	
	 JFrame frame = new JFrame("Error");
	   frame.setVisible(true);
	JOptionPane.showMessageDialog(frame,
			FileMessages.errorOpeningTheFiles,
		    "Error",
		    JOptionPane.ERROR_MESSAGE);
	   frame.setVisible(false);
	   
		JFrame frame = new JFrame("Info");
		frame.setVisible(true);
		JOptionPane.showMessageDialog(frame,
			    FileMessages.readingFromFile);
		frame.setVisible(false);
		
		
		frame = new JFrame("Info");
		frame.setVisible(true);
		JOptionPane.showMessageDialog(frame,
			    FileMessages.finishedReading);
		frame.setVisible(false);
		
		  JFrame frame = new JFrame("Error");
		   frame.setVisible(true);
		JOptionPane.showMessageDialog(frame,
				FileMessages.fileNotFound,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
		   frame.setVisible(false);
		   
		   JFrame frame = new JFrame("Error");
		   frame.setVisible(true);
		JOptionPane.showMessageDialog(frame,
				FileMessages.fieldNotExists,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
		   frame.setVisible(false);
		   */
	
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
