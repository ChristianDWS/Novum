package org.mineacademy.novum.person.attributes;

public interface Nice {

	void smile(int intensity);

	default void eat() {
		System.out.println("Eating banana...");
	}
}
