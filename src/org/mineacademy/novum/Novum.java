package org.mineacademy.novum;

import java.util.*;

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

		Map<String, Integer> map = new HashMap<>();

		map.put("hello", 500);
		map.put("hello2", 200);
		map.put("hello3", 5000);

		System.out.println("Map: " + map);

		recursive(5);
	}

	public static void recursive(int number) {
		if (number > 0) {
			System.out.println(number);

			number--;
			recursive(number);
		}
	}
}
