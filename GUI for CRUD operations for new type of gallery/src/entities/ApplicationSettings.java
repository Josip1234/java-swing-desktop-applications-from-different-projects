package entities;

/***
 * @author Josip Bošnjak
 * @since 03.12.2023.
 * @version 1.0
 * <h1>Description</h1>
 * <p>This is a entity for overriding default application settings. For example, you maybe want to display return message to the log.</p>
 */
public class ApplicationSettings {

private String showMessages;

/***
 * 
 * @param showMessages - default string which will be written in json shape in json file as default setting of displaying messages.
 *<h1>if you want to override setting, use this constructor</h1>
 */
public ApplicationSettings(String showMessages) {
	
	this.showMessages = showMessages;
}

/***
 * <h1>Message logs will be displayed in a shape of popup window with okay button</h1>
 */
public ApplicationSettings() {
	this.showMessages=GeneralMessages.popups;
}

public String getShowMessages() {
	return showMessages;
}

public void setShowMessages(String showMessages) {
	this.showMessages = showMessages;
}

@Override
public String toString() {
	return "{\"ApplicationSettings\":{\"showMessages\":\"" + showMessages + "\"}}\n";
}





}
