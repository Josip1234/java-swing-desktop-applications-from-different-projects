package main;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entities.Columns;
import entities.DatabaseConnection;
import entities.DatabaseMessages;
import entities.DbQuery;
import entities.File;
import entities.FileMessages;

import entities.Tables;
import implementations.DatabaseImpl;
import implementations.FileImplementation;
import implementations.GeneralFunctions;

public class Main {

	public static void main(String[] args) throws SQLException {
		//first use
	       // DatabaseConnection connection = new DatabaseConnection("org.mariadb.jdbc.Driver", "jdbc:mariadb://localhost/test", "root", "");
	       // System.out.println(connection); 

           // String sql = "CREATE TABLE REGISTRATION "
             //       + "(id INTEGER not NULL, "
             //       + " first VARCHAR(255), "
             //       + " last VARCHAR(255), "
             //       + " age INTEGER, "
             //       + " PRIMARY KEY ( id ))";
                 /*  conn=databaseImpl.openConnection(connection, conn, stmt);
                   databaseImpl.insertIntoDatabase(stmt, sql, conn);
                   conn=databaseImpl.closeConnection(stmt, conn);
		*/
		       // System.out.println(connection);
	
	        
	        //second use
	      
	        //third use
		//FileMessages messages = new FileMessages();
		//GeneralFunctions.showMessages("Error",messages,  FileMessages.fieldNotExists);
     
		
		
	   
			 DatabaseConnection con = new DatabaseConnection();
		     con.setDB_URL("jdbc:mariadb://localhost/dynamic_gallery");
		     DatabaseImpl databaseImpl = new DatabaseImpl();
		      Statement stmt=null;
			Connection connection = databaseImpl.openConnection(con, null, stmt);
			stmt = connection.createStatement();
			   DbQuery dbQuery = new DbQuery("Show tables");
               List<Tables> tab=databaseImpl.returnListOfTables(con, databaseImpl, stmt, connection, dbQuery);
               //System.out.println(tab.toString());
               //System.out.println("Show table columns and data types");
               Tables tables = new Tables("storage_system");
               List<Columns> columns = databaseImpl.readColumnsFromTable(con, connection, stmt, tables, databaseImpl);
               //System.out.println(columns.toString());
               //after table has been chosen, read all data from it
               List<String> data = databaseImpl.returnAllDataFromTable(con, databaseImpl, stmt, connection, dbQuery, tables, columns);
               //System.out.println(data.toString());
               Map<String,String> map = new HashMap<String,String>();
               
               JFrame frame1;
               JTable table;
               frame1 = new JFrame("Data from tables");
               frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
               frame1.getContentPane().setLayout(new BorderLayout());
               DefaultTableModel model = new DefaultTableModel();
               String[] colNames = new String[columns.size()];
               
               int index=0;
               for (Columns string : columns) {
				colNames[index]=string.getColumnName();
				index++;
			}
               
               model.setColumnIdentifiers(colNames);
               table = new JTable();
               table.setModel(model);
               table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
               table.setFillsViewportHeight(true);
               JScrollPane scroll = new JScrollPane(table);
               scroll.setHorizontalScrollBarPolicy(
                       JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
               scroll.setVerticalScrollBarPolicy(
                       JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
               
               
               int numberOfStrings=0;
               for(int i=0;i<data.size();i++) {
            	   //System.out.println( i + "String in list: "+data.get(i).toString());
            	   numberOfStrings++;
               }
               System.out.println("Number of strings in list is:"+numberOfStrings);
               System.out.println("Separate strings into strings in array:");
               System.out.println("Print first element until -");
               String[] arrays=new String[numberOfStrings];
               
               for(int i=0;i<data.size();i++) {
            	arrays[i]=data.get(i);   
               }
               //add new vector to store efirst n elements until -
               
               SwingUtilities.invokeLater(new Runnable(){public void run(){
            	   Vector<String> vc= new Vector<String>();
               for(int i=0;i<arrays.length;i++) {
            	   if(arrays[i]=="-") {
            		   System.out.println(vc);
            		   model.addRow(vc);
            		   vc.clear();
            		   vc= new Vector<String>();
            	   }else {
            		   vc.add(arrays[i]);
            	   }
               }
               //Update the model here
           	}});
           
               
               frame1.getContentPane().add(scroll);
               frame1.setVisible(true);
               frame1.setSize(400, 300);
               
    
         
			}
            
	  

	}

