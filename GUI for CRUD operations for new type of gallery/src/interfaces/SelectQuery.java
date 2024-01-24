package interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import entities.Columns;
import entities.DatabaseConnection;
import entities.DbQuery;
import entities.Tables;
import implementations.DatabaseImpl;

public interface SelectQuery {
 public List<Object> returnList(Statement statement,DbQuery dbQuery) throws SQLException;
 public List<Tables> returnListOfTables(DatabaseConnection con, DatabaseImpl databaseImpl, Statement stm, Connection connection,DbQuery dbQuery) throws SQLException;
 public List<String> returnAllDataFromTable(DatabaseConnection con, DatabaseImpl databaseImpl, Statement stm, Connection connection,DbQuery dbQuery, Tables tables, List<Columns> columnNames) throws SQLException;
}
