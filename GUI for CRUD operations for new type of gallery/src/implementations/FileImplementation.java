package implementations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
	public boolean checkIfFileExists(File file) {
		boolean exists=false;
		java.io.File files = new java.io.File(file.getFilename());
		if(files.exists()) exists=true;
		else exists=false;
		return exists;
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

}
