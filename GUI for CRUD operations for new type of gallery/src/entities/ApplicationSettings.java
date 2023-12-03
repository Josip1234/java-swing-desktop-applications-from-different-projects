package entities;

public class ApplicationSettings {
private String showMessages;

//if you want to override setting, use this constructor
public ApplicationSettings(String showMessages) {
	
	this.showMessages = showMessages;
}

//default message show is in as popup messages
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
