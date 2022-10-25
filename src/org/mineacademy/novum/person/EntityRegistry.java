package org.mineacademy.novum.person;

public class EntityRegistry {

	private static int registeredEntities = 0;

	public static void increaseRegisteredEntities() {
		registeredEntities++;
	}

	public static int getRegisteredEntities() {
		return registeredEntities;
	}
}
