package entities;

public class Tables extends DatabaseConnection {
private String TableName;

public Tables(String string) {
	this.TableName=string;
}

public Tables(String jDBC_DRIVER, String dB_URL, String uSER, String pASS,String TableName) {
	super(jDBC_DRIVER, dB_URL, uSER, pASS);
	this.TableName=TableName;
}

public String getTableName() {
	return TableName;
}

public void setTableName(String tableName) {
	TableName = tableName;
}



}
