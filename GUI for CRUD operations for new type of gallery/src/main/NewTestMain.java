package main;

import entities.ApplicationSettings;
import entities.File;
import entities.GeneralMessages;
import implementations.FileImplementation;

public class NewTestMain {

	public static void main(String[] args) {
		File file = new File();
		FileImplementation fileImplementation = new FileImplementation();
		System.out.println(file.getAppConfigFileName());
		fileImplementation.createFileIfFileDoesNotExists(file, file.getAppConfigFileName());
		
		ApplicationSettings applicationSettings = new ApplicationSettings();
		System.out.println(applicationSettings.toString());
		System.out.println("New setting:");
		applicationSettings.setShowMessages(GeneralMessages.log);
		System.out.println(applicationSettings.toString());
		

	}

}
