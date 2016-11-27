package com.example.hoc;

public class Day2_AppendDelete {

	public static void main(String[] args) {
		appendDelete("hackerhappy","hackerrank",7);
	}
	
	
	public static void appendDelete(String s1,String s2,int k){
		if(k<=0){
			System.out.println("No");
			return;
		}
		
		if(s1.equals(s2)){
			if(k==2*s1.length()+1){
				System.out.println("Yes");
				return;
			}else{
				System.out.println("No");
				return;
			}
					
		}else{
			int len1=s1.length();
			int len2=s2.length();
			int identicalLength=0;
			
			for(int i=0;i<len2&&i<len1;i++){
				if(s1.charAt(i)==s2.charAt(i)){
						identicalLength=i;
				}else{
					break;
				}		
			}
			if(len1>=len2 && len2!=0){
				if(k==(len1-(identicalLength+1))+(len2-(identicalLength+1))){
					System.out.println("Yes");
				}else{
					System.out.println("No");

				}	
			}else{
					if(k==Math.abs(len1-len2)){
						System.out.println("Yes");
					}else{
						System.out.println("No");
					}	
			}
					
		}
		
		
	}
	
}
