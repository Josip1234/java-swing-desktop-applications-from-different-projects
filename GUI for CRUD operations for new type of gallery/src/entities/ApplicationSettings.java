package entities;

/***
 * @author Josip Bošnjak
 * @since 03.12.2023.
 * @version 1.0
 * <h1>Description</h1>
 * <p>This is a entity for overriding default application settings. You can change diplay message of our application as popup, or it can be only log.</p>
 */
public class ApplicationSettings {

/**
 * @author Josip Bošnjak
 * This variable will represent default value of message display in our application. This value is in json file, it will represent way of 
 * displaying messages like log, or like popup.
 */
private String showMessages;

/***
 * 
 * @param showMessages - default string value, will represent way of displaying messages in our application.
 *<h1>if you want to override setting, use this constructor</h1>
 */
public ApplicationSettings(String showMessages) {
	
	this.showMessages = showMessages;
}

/***
 * Default constructor, default value of displaying messages is popup. If you want to change that, use constructor with parameter 
 * show messages
 */
public ApplicationSettings() {
	this.showMessages=GeneralMessages.popups;
}
/**
 * function for getting default display message value.
 * @return default message value
 */
public String getShowMessages() {
	return showMessages;
}
/***
 * Override default message value without using constructor.
 * @param showMessages - new message value to override default message value.
 */
public void setShowMessages(String showMessages) {
	this.showMessages = showMessages;
}

/***
 * Display string value in a json format.
 */
@Override
public String toString() {
	return "{\"ApplicationSettings\":{\"showMessages\":\"" + showMessages + "\"}}\n";
}





}
