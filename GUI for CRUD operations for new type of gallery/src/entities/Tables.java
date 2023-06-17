package entities;

public class Tables {
private String TableName;


public Tables(String TableName) {
	
	this.TableName=TableName;
}

public Tables() {
	// TODO Auto-generated constructor stub
}

public String getTableName() {
	return TableName;
}

public void setTableName(String tableName) {
	TableName = tableName;
}

@Override
public String toString() {
	return getTableName();
}



}
