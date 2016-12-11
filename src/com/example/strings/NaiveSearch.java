package com.example.strings;

public class NaiveSearch {

	public static void main(String[] args) {
		findWord("AABAACAADAABAAABAA", "AABA");
	}

	private static void findWord(String input, String key) {

		if ((input != null && input.isEmpty())
				|| (key != null && key.isEmpty())) {

			throw new IllegalArgumentException("Cant have a null key or input");
		}

		char[] inputArray = input.toCharArray();
		char[] pattern = key.toCharArray();
		int N = inputArray.length;
		int M = pattern.length;

		for (int i = 0; i < N - M; i++) {
			int j;
			for (j = 0; j < M; j++) {
				if (inputArray[i + j] != pattern[j]) {
					break;
				}
				
			}
			if (j == M) {
				System.out.println("Pattern found @ " + i);
			}

		}

	}

}
