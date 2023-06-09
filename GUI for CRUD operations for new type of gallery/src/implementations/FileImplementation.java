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
	public void readFromAFile(File file) {
		Scanner input = null;
		try {
			input=new Scanner(new FileInputStream(file.getFilename()));
			String line = input.nextLine();
			System.out.println(line);
		} catch (FileNotFoundException e) {
			System.out.println(FileMessages.fileNotFound);
			e.printStackTrace();
		}
		
	}

}
