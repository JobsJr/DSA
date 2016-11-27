package com.example.algo;

import java.util.Scanner;

public class Kangaroo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x1=sc.nextInt();
		int v1=sc.nextInt();
		int x2=sc.nextInt();
		int v2=sc.nextInt();

		isMeet(x1,x2,v1,v2);
	
	}

	private static void isMeet(int x1, int x2, int v1, int v2) {
		if(x1==x2 && v1==v2){
			System.out.println("YES");
		}else{
			if(v1 > v2 && ((x2-x1)%(v1-v2))==0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
	}

}
