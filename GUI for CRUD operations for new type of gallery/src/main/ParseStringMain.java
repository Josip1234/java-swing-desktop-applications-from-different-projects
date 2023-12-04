package main;

import implementations.FileImplementation;

public class ParseStringMain {

	public static void main(String[] args) {
		String value="{\"ApplicationSettings\":{\"showMessages\":\"Show popups\"}}";
		FileImplementation fileImplementation = new FileImplementation();
		fileImplementation.parse(value, "showMessages");

	}

}
