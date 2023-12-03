package entities;

public class File {
//name of the file of database config	
private final String fileName="databaseConfig.json";
//this is the name of application setting file
private final String appConfig="applicationConfig.json";
//this is a name of file where log will be saved.
private final String logFile="logFile.txt";


public File() {
	
}

public String getFilename() {
	return fileName;
}

public String getAppConfigFileName() {
   return appConfig;	
}

public String getLogFile() {
	return logFile;
}

}
