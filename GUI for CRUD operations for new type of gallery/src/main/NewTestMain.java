package main;

import entities.ApplicationSettings;
import entities.GeneralMessages;

public class NewTestMain {

	public static void main(String[] args) {
		ApplicationSettings applicationSettings = new ApplicationSettings();
		System.out.println(applicationSettings.toString());
		System.out.println("New setting:");
		applicationSettings.setShowMessages(GeneralMessages.log);
		System.out.println(applicationSettings.toString());

	}

}
