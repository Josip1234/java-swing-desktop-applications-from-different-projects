package entities;

public class Columns extends Tables {
private String columnName;
private String columnType;

public Columns() {
	
}
public Columns(String TableName, String columnName,String columnType) {
	super(TableName);
	this.columnName=columnName;
	this.columnType=columnType;
	
}
public String getColumnName() {
	return columnName;
}
public void setColumnName(String columnName) {
	this.columnName = columnName;
}
public String getColumnType() {
	return columnType;
}
public void setColumnType(String columnType) {
	this.columnType = columnType;
}
@Override
public String toString() {
	return columnName;
}


}
