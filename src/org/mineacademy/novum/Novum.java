package org.mineacademy.novum;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Novum {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();

		numbers.add(1);
		numbers.add(14);
		numbers.add(798);

		// 3 ways to iterate through lists
		for (Integer number : numbers)
			System.out.println(number);

		for (int index = 0; index < numbers.size(); index++)
			System.out.println(numbers.get(index));

		for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext(); ) {
			int number = iterator.next();

			System.out.println(number);
		}
	}
}
