package entities;

public class DbQuery extends DatabaseConnection {
 private String query;

public DbQuery() {
	// TODO Auto-generated constructor stub
}

public DbQuery(String jDBC_DRIVER, String dB_URL, String uSER, String pASS,String query) {
	super(jDBC_DRIVER, dB_URL, uSER, pASS);
	this.query=query;
}

public DbQuery(String query) {
	this.query=query;
}

public String getQuery() {
	return query;
}

public void setQuery(String query) {
	this.query = query;
}



}
