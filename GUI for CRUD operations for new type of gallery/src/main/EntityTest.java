package main;

import entities.ApplicationSettings;
import entities.File;
import entities.GeneralMessages;
import entities.LogEntity;
import implementations.FileImplementation;

public class EntityTest {

	public static void main(String[] args) {
		LogEntity entity = new LogEntity(1,GeneralMessages.closingApplication);
		System.out.println(entity.toString());
		FileImplementation fileImplementation = new FileImplementation();
		File file= new File();
		ApplicationSettings applicationSettings = new ApplicationSettings();
		applicationSettings.setShowMessages(fileImplementation.readFromAFile(file, file.getAppConfigFileName()));
		fileImplementation.writeToAFile(file, applicationSettings, file.getLogFile(),entity);		

	}

}
