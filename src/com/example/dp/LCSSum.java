package com.example.dp;

import java.io.*;
import java.util.*;

public class LCSSum {

	public static void main(String[] args) {
		 int [] arr={3,5,10,15,17,12,9};
		 System.out.println("Sum:= "+sumOfConsecutiveNums(arr,4));
	}

	private static int sumOfConsecutiveNums(int arr[], int k) {
		// Table to store max sum
		int[] dp = new int[arr.length];
		int N = arr.length;
		Arrays.sort(arr);

		dp[0] = 0;

		for (int i = 1; i < N; i++) {

			dp[i] = dp[i - 1];// Store it.This means,max possible sum till this
							  // point is its prev one only

			if (arr[i] - arr[i - 1] < k) {
				if (i >= 2) {
					dp[i] = Math.max(dp[i], dp[i - 2] + arr[i] + arr[i - 1]);
				} else {
					dp[i] = Math.max(dp[i], arr[i] + arr[i - 1]);
				}
			}

		}

		return dp[N - 1];
	}

}
