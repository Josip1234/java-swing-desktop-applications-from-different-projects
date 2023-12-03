package implementations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entities.ApplicationSettings;
import entities.DatabaseConnection;
import entities.DatabaseMessages;
import entities.File;
import entities.FileMessages;
import interfaces.FileOperations;

public class FileImplementation implements FileOperations {
	
	public FileImplementation() {
		
	}

	@Override
	public boolean writeToAFile(File file,DatabaseConnection connection) {
		boolean done=false;
		PrintWriter outPrintWriter = null;
		try {
			outPrintWriter=new PrintWriter(new FileOutputStream(file.getFilename()));
			FileMessages messages = new FileMessages();
			GeneralFunctions.showMessages("Info",messages,   FileMessages.writingToAFile);
			outPrintWriter.println(connection.toString());
			messages = new FileMessages();
			GeneralFunctions.showMessages("Info",messages,   FileMessages.finishedWriting);
			outPrintWriter.close();
			
		} catch (FileNotFoundException e) {
			FileMessages messages = new FileMessages();
			GeneralFunctions.showMessages("Error",messages,  FileMessages.errorOpeningTheFiles);
		
			done=false;
			e.printStackTrace();
		}
		return done;
	}

	@Override
	public String readFromAFile(File file) {
		String value="";
		Scanner input = null;
		try {
			input=new Scanner(new FileInputStream(file.getFilename()));
			FileMessages messages = new FileMessages();
			GeneralFunctions.showMessages("Info",messages,   FileMessages.readingFromFile);
			value = input.nextLine();
			messages = new FileMessages();
			GeneralFunctions.showMessages("Info",messages,  FileMessages.finishedReading);
		
		} catch (FileNotFoundException e) {
			FileMessages messages = new FileMessages();
			GeneralFunctions.showMessages("Error",messages,  FileMessages.fileNotFound);
		
			
			value="";
			e.printStackTrace();
		}
		input.close();
		return value;
		
	}

	@Override
	public boolean checkIfFileExists(File file,String whatFile) {
		boolean exists=false;
		java.io.File files=returninstanceOfFile(file, whatFile);

		if(files.exists()==true) exists=true;
		else exists=false;
		return exists;
	}
	
	//return instance of java.io.file depending of file in class entity file
	public java.io.File returninstanceOfFile(File file,String whatfile) {
		java.io.File files=null;
		if(whatfile.contentEquals(file.getFilename())) {
			files = new java.io.File(file.getFilename());
		}else if(whatfile.contentEquals(file.getAppConfigFileName())) {
			files = new java.io.File(file.getAppConfigFileName());
		}else if(whatfile.contentEquals(file.getLogFile())) {
			files = new java.io.File(file.getLogFile());
		}
		return files;
	}

	@Override
	public String parse(String element, String wordToParse) {
		String parsed="";
		if(wordToParse.contentEquals("JDBC_DRIVER")) {
		    parsed=element;
	       parsed=parsed.replace('{', ' ');
	       parsed=parsed.replace('"', ' ');
	       parsed=parsed.replace(':', ' ');
	       parsed=parsed.replace(',', ' ');
	       parsed=parsed.replace('}', ' ');
	       parsed=parsed.trim();
	       parsed=parsed.replaceAll("DatabaseConnection    ", "");
	       parsed=parsed.replaceAll("DB_URL.*", "");
	       parsed=parsed.replaceAll("JDBC_DRIVER", "");
	       parsed=parsed.trim();
		
		}else if(wordToParse.contentEquals("DB_URL")) {
		    parsed=element;
		       parsed=parsed.replace('{', ' ');
		       parsed=parsed.replace('"', ' ');
		       parsed=parsed.replace('}', ' ');
		       parsed=parsed.trim();
		       parsed=parsed.replaceAll("DatabaseConnection    ", "");
		       parsed=parsed.replaceFirst(".*DB_URL", "");
		       parsed=parsed.trim();
		       parsed=parsed.replaceFirst(":", "");
		       parsed=parsed.replaceFirst(" ,", "");
		       parsed=parsed.replaceAll("USER.*", "");
		       parsed=parsed.trim();
			    
		}else if(wordToParse.contentEquals("USER")) {
		    parsed=element;
		       parsed=parsed.replace('{', ' ');
		       parsed=parsed.replace('"', ' ');
		       parsed=parsed.replace(':', ' ');
		       parsed=parsed.replace(',', ' ');
		       parsed=parsed.replace('}', ' ');
		       parsed=parsed.trim();
		       parsed=parsed.replaceAll("DatabaseConnection    ", "");
		       parsed=parsed.replaceAll(".*USER", "");
		       parsed=parsed.trim();
		       parsed=parsed.replaceAll("PASS.*", "");
		       parsed=parsed.trim();
		      
		}else if(wordToParse.contentEquals("PASS")) {
		    parsed=element;
		       parsed=parsed.replace('{', ' ');
		       parsed=parsed.replace('"', ' ');
		       parsed=parsed.replace('}', ' ');
		       parsed=parsed.trim();
		       parsed=parsed.replaceAll("DatabaseConnection    ", "");
		       parsed=parsed.replaceFirst(".*PASS", "");
		       parsed=parsed.replaceFirst(":", "");
		       parsed=parsed.trim();
		       printString(parsed);
			    
		}else {
			FileMessages messages = new FileMessages();
			GeneralFunctions.showMessages("Error",messages,  FileMessages.fieldNotExists);
		
		}
  
		return parsed;
	}

	@Override
	public void printString(String string) {
		System.out.println(string);
		
	}

	@Override
	public boolean createFileIfFileDoesNotExists(File file, String whatFileToCreate) {
		boolean exists=false;
		boolean created=false;
		exists=checkIfFileExists(file,whatFileToCreate);
     
		if(exists==true) {
			exists=true;
			created=false;
		
		}else {
			System.out.println("ne postoji");
			java.io.File fil= returninstanceOfFile(file, whatFileToCreate);
			try {
				FileOutputStream fileOutputStream = new FileOutputStream(fil);
				fileOutputStream.close();
				created=true;
				System.out.println("kreiran je file");
			} catch (IOException e) {
			   created=false;
System.out.println("nije kreiran file");
				e.printStackTrace();
			}
		}
		return created;
	}

}
