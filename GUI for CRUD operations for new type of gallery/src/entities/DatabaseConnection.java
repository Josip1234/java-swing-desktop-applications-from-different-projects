package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
private String JDBC_DRIVER;
private String DB_URL;
private String USER;
private String PASS;
public DatabaseConnection(String jDBC_DRIVER, String dB_URL, String uSER, String pASS) {
	JDBC_DRIVER = jDBC_DRIVER;
	DB_URL = dB_URL;
	USER = uSER;
	PASS = pASS;
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



}
