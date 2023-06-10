package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
private String JDBC_DRIVER;
private String DB_URL;
private String USER;
private String PASS;

public DatabaseConnection() {
	this.JDBC_DRIVER = "";
	this.DB_URL = "";
	this.USER = "";
	this.PASS = "";
}

public DatabaseConnection(String jDBC_DRIVER, String dB_URL, String uSER, String pASS) {
	this.JDBC_DRIVER = jDBC_DRIVER;
	this.DB_URL = dB_URL;
	this.USER = uSER;
	this.PASS = pASS;
}
public String getJDBC_DRIVER() {
	return JDBC_DRIVER;
}
public void setJDBC_DRIVER(String jDBC_DRIVER) {
	JDBC_DRIVER = jDBC_DRIVER;
}
public String getDB_URL() {
	return DB_URL;
}
public void setDB_URL(String dB_URL) {
	DB_URL = dB_URL;
}
public String getUSER() {
	return USER;
}
public void setUSER(String uSER) {
	USER = uSER;
}
public String getPASS() {
	return PASS;
}
public void setPASS(String pASS) {
	PASS = pASS;
}
@Override
public String toString() {
	return "{\"DatabaseConnection\":{\"JDBC_DRIVER\":\"" + JDBC_DRIVER + "\", \"DB_URL\":\"" + DB_URL
			+ "\", \"USER\":\"" + USER + "\", \"PASS\":\"" + PASS + "\"}}\n";
}




}
