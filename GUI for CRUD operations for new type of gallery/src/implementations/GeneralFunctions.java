package implementations;

import entities.DatabaseConnection;
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
}
