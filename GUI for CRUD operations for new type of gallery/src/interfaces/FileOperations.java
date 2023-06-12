package interfaces;

import entities.DatabaseConnection;
import entities.File;

public interface FileOperations {
      boolean writeToAFile(File file,DatabaseConnection connection);
      String readFromAFile(File file);
      boolean checkIfFileExists(File file);
      String parse(String element,String wordToParse);
      void printString(String string);
}
