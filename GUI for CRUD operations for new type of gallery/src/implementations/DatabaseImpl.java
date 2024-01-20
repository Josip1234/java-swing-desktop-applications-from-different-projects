package implementations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entities.Columns;
import entities.DatabaseConnection;
import entities.DatabaseMessages;
import entities.DbQuery;
import entities.GeneralMessages;
import entities.Tables;
import interfaces.DatabaseInterface;
import interfaces.SelectQuery;

public class DatabaseImpl implements DatabaseInterface,SelectQuery  {
	

	public DatabaseImpl() {
	
	}

	@Override
	public Connection openConnection(DatabaseConnection connection, Connection conn, Statement stmt) {
		DatabaseMessages message = new DatabaseMessages();
        GeneralFunctions.showMessages("Info", message, DatabaseMessages.connecting);
        try {
			Class.forName(connection.getJDBC_DRIVER());
			DatabaseMessages messages = new DatabaseMessages();
			GeneralFunctions.showMessages("Info",messages, DatabaseMessages.driverRegistered);
		} catch (ClassNotFoundException e) {
			DatabaseMessages messages = new DatabaseMessages();
			GeneralMessages generalMessages=new GeneralMessages();
			GeneralFunctions.showMessages("Error",messages, DatabaseMessages.driverNotRegistered);
			GeneralFunctions.showMessages("Error", generalMessages, GeneralMessages.closingApplication);
			//exit the app if driver is not registered
			System.exit(0);
		}

      

        try {
			conn = DriverManager.getConnection(
			        connection.getDB_URL(), connection.getUSER(), connection.getPASS());
			DatabaseMessages messages = new DatabaseMessages();
			GeneralFunctions.showMessages("Info",messages, DatabaseMessages.databaseIsConnected);
		} catch (SQLException e) {
			DatabaseMessages messages = new DatabaseMessages();
			GeneralFunctions.showMessages("Error",messages, DatabaseMessages.failedToConnectToDatabase);
			e.printStackTrace();
		}
    
		return conn;
	}

	@Override
	public boolean insertIntoDatabase(Statement statement, String query,Connection con) {
		boolean done=false;
		try {
			statement = con.createStatement();
			done=true;
			System.out.println(DatabaseMessages.databaseInsertWasSuccessfull);
		} catch (SQLException e1) {
			done=false;
			System.out.println(DatabaseMessages.failedToInsertData);
			e1.printStackTrace();
		}

		try {
			statement.executeUpdate(query);
			done=true;
			System.out.println(DatabaseMessages.databaseInsertWasSuccessfull);
		} catch (SQLException e) {
			done=false;
			System.out.println(DatabaseMessages.failedToInsertData);
			e.printStackTrace();
		}
		return done;
	}

	@Override
	public Connection closeConnection(Statement statement, Connection con) {
	
		   if (statement != null) {
               try {
           		DatabaseMessages messages = new DatabaseMessages();
        		GeneralFunctions.showMessages("Info",messages, DatabaseMessages.closingConnection);
				con.close();
				messages = new DatabaseMessages();
				GeneralFunctions.showMessages("Info",messages,  DatabaseMessages.conectionClosed);
		
			} catch (SQLException e) {
				DatabaseMessages messages = new DatabaseMessages();
				GeneralFunctions.showMessages("Error",messages,  DatabaseMessages.problemClosingConnection);
			}
           }
		   if (statement != null) {
               try {
            		DatabaseMessages messages = new DatabaseMessages();
            		GeneralFunctions.showMessages("Info",messages,  DatabaseMessages.closingConnection);
				con.close();
				messages = new DatabaseMessages();
				GeneralFunctions.showMessages("Info",messages,  DatabaseMessages.conectionClosed);
			
			} catch (SQLException e) {
				DatabaseMessages messages = new DatabaseMessages();
				GeneralFunctions.showMessages("Error",messages,  DatabaseMessages.problemClosingConnection);
				e.printStackTrace();
			}
           }
		return con;
	}

	@Override
	public List<Object> returnList(Statement statement, DbQuery dbQuery) throws SQLException {
		List<Object> list = new ArrayList<Object>();
	    ResultSet rs= statement.executeQuery(dbQuery.getQuery());
	    while(rs.next()) {
	    	
	    	list.add(rs.getString(1));
	    }
		return list;
	}

	@Override
	public List<Tables> returnListOfTables(DatabaseConnection con, DatabaseImpl databaseImpl, Statement stm,
			Connection connection, DbQuery dbQuery) throws SQLException {
		  List<Object> list = new ArrayList<Object>();
		   List<Tables> tables = new ArrayList<Tables>();
			list=databaseImpl.returnList(stm, dbQuery);
			
			for (Object object : list) {
				//System.out.println("Object:"+object);
				tables.add(new Tables(object.toString()));
			}
			return tables;
	}

	@Override
	public List<Columns> readColumnsFromTable(DatabaseConnection connection, Connection conn, Statement stmt,Tables tables, DatabaseImpl databaseImpl) {
			DbQuery dbQuery = new DbQuery("select * from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME='"+tables.getTableName()+"'");
			conn = databaseImpl.openConnection(connection, conn, stmt);
			List<Columns> col = new ArrayList<Columns>();
			try {
				stmt=conn.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ResultSet resultSet;
			try {
				
				resultSet=stmt.executeQuery(dbQuery.getQuery());
				while(resultSet.next()) {
					Columns columns = new Columns();
					columns.setTableName(resultSet.getString("TABLE_NAME"));
					columns.setColumnName(resultSet.getString("COLUMN_NAME"));
					columns.setColumnType(resultSet.getString("DATA_TYPE"));
					System.out.println(columns.getColumnName());
				    col.add(columns);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn=databaseImpl.closeConnection(stmt, conn);
		  
		return col;
	}

	@Override
	public List<String> returnAllDataFromTable(DatabaseConnection con, DatabaseImpl databaseImpl, Statement stm,
			Connection connection, DbQuery dbQuery, Tables tables, List<Columns> columns) throws SQLException {
		DbQuery query = new DbQuery("SELECT * FROM "+ tables.getTableName()+"");
		connection=databaseImpl.openConnection(con, connection, stm);
		List<String> data=new ArrayList<String>();
		stm=connection.createStatement();
		ResultSet resultSet;
		resultSet=stm.executeQuery(query.getQuery());
		
		while(resultSet.next()) {
		//fetch column names from list of columns
			for (Columns column : columns) {
				String columnName = new String();
				columnName=column.getColumnName();
				String temp=resultSet.getString(columnName);
				data.add(temp);
				
			}
			data.add("-");
		}
		return data;
	}



}
