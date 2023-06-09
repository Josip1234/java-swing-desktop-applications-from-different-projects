package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
private String db_driver;
private String protocol;
private String db_name;
private Connection conn;
private DriverManager driverManager;
private Statement statement;

public DatabaseConnection(String db_driver, String protocol, String db_name, Connection conn,
		DriverManager driverManager, Statement statement) {
	this.db_driver = db_driver;
	this.protocol = protocol;
	this.db_name = db_name;
	this.conn = conn;
	this.driverManager = driverManager;
	this.statement = statement;
}

public String getDb_driver() {
	return db_driver;
}

public void setDb_driver(String db_driver) {
	this.db_driver = db_driver;
}

public String getProtocol() {
	return protocol;
}

public void setProtocol(String protocol) {
	this.protocol = protocol;
}

public String getDb_name() {
	return db_name;
}

public void setDb_name(String db_name) {
	this.db_name = db_name;
}

public Connection getConn() {
	return conn;
}

public void setConn(Connection conn) {
	this.conn = conn;
}

public DriverManager getDriverManager() {
	return driverManager;
}

public void setDriverManager(DriverManager driverManager) {
	this.driverManager = driverManager;
}

public Statement getStatement() {
	return statement;
}

public void setStatement(Statement statement) {
	this.statement = statement;
}




}
