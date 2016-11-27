package com.example.algo;

import java.util.Scanner;

public class ViralAdvertising {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int Tlikes=0;
		int shares=1;
		int likes=0;
		
		for(int i=1;i<=n;i++){
			if(i==1){
				likes=2;
			}else{
				likes=shares/2;
			}
			
			shares=likes*3;
			Tlikes+=likes;
		}
		
		System.out.println(Tlikes);
	}

}
