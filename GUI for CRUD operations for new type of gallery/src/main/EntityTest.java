package main;

import entities.GeneralMessages;
import entities.LogEntity;

public class EntityTest {

	public static void main(String[] args) {
		LogEntity entity = new LogEntity(1,GeneralMessages.closingApplication);
		System.out.println(entity.toString());

	}

}
