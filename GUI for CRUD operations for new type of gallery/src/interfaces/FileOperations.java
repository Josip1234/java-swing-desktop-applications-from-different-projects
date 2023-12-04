package interfaces;

import entities.ApplicationSettings;
import entities.DatabaseConnection;
import entities.File;

public interface FileOperations {
	//create file if not exists, but we need to check what file to create in class of entity file
	 boolean createFileIfFileDoesNotExists(File file, String whatFiletoCreate);
      boolean writeToAFile(File file,DatabaseConnection connection);
      String readFromAFile(File file);
      //check if file exists, depending on what file to create, that file needs to be listened in file entity
      boolean checkIfFileExists(File file,String whatfile);
      String parse(String element,String wordToParse);
      void printString(String string);
      //return instancwe of file denending on file class
      public java.io.File returninstanceOfFile(File file,String whatfile);
      //write to a file some value into a file from file class This value will be selected setting for a log, for example
      boolean writeToAFile(File file, ApplicationSettings applicationSettings, String whatFileInClass);
}
