package interfaces;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import entities.Columns;
import entities.DatabaseConnection;
import entities.Tables;
import implementations.DatabaseImpl;

public interface DatabaseInterface {
 Connection openConnection(DatabaseConnection connection,  Connection conn, Statement stmt);
 boolean insertIntoDatabase(Statement statement, String query,Connection con);
 Connection closeConnection(Statement statement, Connection con);
 List<Columns> readColumnsFromTable(DatabaseConnection connection, Connection conn, Statement stmt,Tables tables, DatabaseImpl databaseImpl);
}
