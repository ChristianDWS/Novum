package org.mineacademy.novum;

import java.util.Scanner;

public class Novum {

	private static final int LEFT_HAND_NUMBER = 0;
	private static final int RIGHT_HAND_NUMBER = 1;
	private static final int OPERATOR = 2;

	public static void main(String[] args) {
		Novum novum = new Novum();

		try {
			novum.runCalculator();
		} catch (Throwable throwable) {
			System.out.println("Ooops! " + throwable.getMessage());

			throwable.printStackTrace();
		}
	}

	private void runCalculator() {
		Scanner scanner = new Scanner(System.in);
		String message = "";

		int mode = LEFT_HAND_NUMBER; // 0, 1 or 2
		double[] numbers = new double[2];

		while (!message.equals("exit")) {
			if (mode > OPERATOR)
				mode = 0;

			if (mode == LEFT_HAND_NUMBER)
				System.out.println("Please type the first number.");
			else if (mode == RIGHT_HAND_NUMBER)
				System.out.println("Please type the second number.");
			else
				System.out.println("Please type the operator.");

			message = scanner.nextLine();

			if (mode == LEFT_HAND_NUMBER) {
				if (isNumberValid(message))
					numbers[0] = Double.parseDouble((message));
				else {
					System.out.println("Invalid first number: " + message);

					continue; // continue the loop
				}

			} else if (mode == RIGHT_HAND_NUMBER) {
				if (isNumberValid(message))
					numbers[1] = Double.parseDouble((message));
				else {
					System.out.println("Invalid second number: " + message);

					continue; // continue the loop
				}

			} else {
				if (isOperatorValid(message))
					System.out.println(numbers[0] + " " + message + " " + numbers[1] + " = " + calculateNumbers(numbers[0], numbers[1], message));

				else {
					System.out.println("Invalid operator: " + message);

					continue; // continue the loop
				}
			}

			mode++; // next mode
		}

		System.out.println("The program has quit. Byte!");
	}

	// checks if number (from String) is a double
	private boolean isNumberValid(String number) {
		try {
			Double.parseDouble(number);

			return true;
		} catch (NumberFormatException exception) {
			return false;
		}
	}

	// checks if operator (from String) is valid
	private boolean isOperatorValid(String operator) {
		return operator.equals("+") || operator.equals("-") || operator.equals("/") || operator.equals("*") || operator.equals("%");
	}

	// calculates two numbers with operator e.g. 2 + 2 = 4
	private double calculateNumbers(double firstNumber, double secondNumber, String operator) {
		// (a switch statement would probably look better but we have not learned that yet)
		if (operator.equals("+"))
			return firstNumber + secondNumber;
		else if (operator.equals("-"))
			return firstNumber - secondNumber;
		else if (operator.equals("/"))
			return firstNumber / secondNumber;
		else if (operator.equals("*"))
			return firstNumber * secondNumber;
		else if (operator.equals("%"))
			return firstNumber % secondNumber;
		else
			return 0;
	}
}
