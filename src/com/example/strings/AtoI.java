package com.example.strings;

public class AtoI {

	public static void main(String[] args) {
		int value=aToi("100");
		System.out.println(""+value);
		int value1=aToi("-98");
		System.out.println(""+value1);
		
	}

	private static int aToi(String input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException("Wrong input!!!");
		}
		input = input.trim();
		int length = input.length();
		char sign = '+';
		int i = 0;
		if (input.charAt(i) == '-') {
			sign = '-';
			i++;
		}
		int result = 0;
		int digit = -1;
		while (i < length && (input.charAt(i) >= '0' || input.charAt(i) <= '9')) {
			digit = input.charAt(i)-'0';
			result += (digit * Math.pow(10, length - i - 1));
			i++;
		}
		if (sign == '-') {
			result = -result;
		}
		if (result > Integer.MAX_VALUE) {
			result = Integer.MAX_VALUE;
		}

		return result;
	}

}
