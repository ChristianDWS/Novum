package org.mineacademy.novum;

import java.util.Scanner;

public class Novum {

	private enum Mode {
		LEFT_HAND_NUMBER,
		RIGHT_HAND_NUMBER,
		OPERATOR
	}

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

		Mode mode = Mode.LEFT_HAND_NUMBER;
		double[] numbers = new double[2];

		while (!message.equals("exit")) {
			if (mode == Mode.LEFT_HAND_NUMBER)
				System.out.println("Please type the first number.");

			else if (mode == Mode.RIGHT_HAND_NUMBER)
				System.out.println("Please type the second number.");

			else
				System.out.println("Please type the operator.");

			message = scanner.nextLine();

			if (mode == Mode.LEFT_HAND_NUMBER) {
				if (isNumberValid(message)) {
					numbers[0] = Double.parseDouble((message));
					mode = Mode.RIGHT_HAND_NUMBER;
				} else
					System.out.println("Invalid first number: " + message);

			} else if (mode == Mode.RIGHT_HAND_NUMBER) {
				if (isNumberValid(message)) {
					numbers[1] = Double.parseDouble((message));
					mode = Mode.OPERATOR;
				} else
					System.out.println("Invalid second number: " + message);

			} else {
				if (isOperatorValid(message)) {
					System.out.println(numbers[0] + " " + message + " " + numbers[1] + " = " + calculateNumbers(numbers[0], numbers[1], message));

					mode = Mode.LEFT_HAND_NUMBER;
				} else
					System.out.println("Invalid operator: " + message);

			}
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
		switch (operator) {
			case "+":
				return firstNumber + secondNumber;
			case "-":
				return firstNumber - secondNumber;
			case "/":
				return firstNumber / secondNumber;
			case "*":
				return firstNumber * secondNumber;
			case "%":
				return firstNumber % secondNumber;
			default:
				return 0;
		}
	}
}
