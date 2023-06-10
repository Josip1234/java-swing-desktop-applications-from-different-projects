package implementations;

import entities.DatabaseConnection;
import entities.File;

public class GeneralFunctions {
   
	public static void initApp() {
		boolean doesFileExists=false;
		DatabaseConnection connection = new DatabaseConnection();
		File file = new File();
	    FileImplementation fileImplementation = new FileImplementation();
	    doesFileExists=fileImplementation.checkIfFileExists(file);
	    if(doesFileExists==true) {
	    	//čitaj iz file-a config
	    	//stavi u text field
	    	System.out.println("Čitam polja iz configa...");
	    }else {
	    	//stvori novi config upiši defaultne vrijednosti 
	    	//javi poruku da se upišu prazna polja 
	    	//ta polja pohrani u config
	    	System.out.println("Stvaram novo polje...");
	    }
	}
}
