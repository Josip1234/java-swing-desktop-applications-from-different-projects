package implementations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import entities.DatabaseConnection;
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
			outPrintWriter.println(connection.toString());
			outPrintWriter.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(FileMessages.errorOpeningTheFiles);
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
			value = input.nextLine();
		
		} catch (FileNotFoundException e) {
			System.out.println(FileMessages.fileNotFound);
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
			System.out.println(FileMessages.fieldNotExists);
		}
  
		return parsed;
	}

	@Override
	public void printString(String string) {
		System.out.println(string);
		
	}

}
