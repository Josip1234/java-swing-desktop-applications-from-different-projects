package interfaces;

import java.sql.Connection;
import java.sql.Statement;

import entities.DatabaseConnection;

public interface DatabaseInterface {
 Connection openConnection(DatabaseConnection connection,  Connection conn, Statement stmt);
 boolean insertIntoDatabase(Statement statement, String query,Connection con);
 Connection closeConnection(Statement statement, Connection con);
}
