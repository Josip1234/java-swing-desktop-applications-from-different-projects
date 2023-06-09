package interfaces;

import entities.DatabaseConnection;
import entities.File;

public interface FileOperations {
      boolean writeToAFile(File file,DatabaseConnection connection);
      void readFromAFile(File file);
}
