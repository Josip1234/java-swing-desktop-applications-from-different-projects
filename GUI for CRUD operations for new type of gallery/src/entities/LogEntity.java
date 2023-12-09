package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * 
 * @author Korisnik
 * Entity for log file
 *
 */
public class LogEntity {
//entity format will be integer row, will count number of rows of file data
	int index;
	//second date and time of the log, will get current timestamp, with current format date (will probably update it)
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	Date date = new Date();
	//activate format date by dateFormat.format(date)
	String currentDate=dateFormat.format(date);
	//display message in a row
	String message="";
	public LogEntity() {
		
	}
	public LogEntity(int index, String message) {
		
		this.index = index;
		this.message = message;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "{\"LogEntity\":{\"index\":\"" + index + "\", \"currentDate\":\"" + currentDate + "\", \"message\":\""
				+ message + "\"}}";
	}
	
	
	
	
}
