package com.example.stack;

/**
 * Implementing 2 stacks using one single array
 * @author rajeevkr
 *
 */
public class TwoStack {
	private int top1;
	private int top2;
	private int size;
	private int [] array;
	
	public TwoStack(int n){
		array=new int[n];
		size=n;
		top1=-1;
		top2=size;
	}
	
	
	public void push1(int x){
		if(top1<top2-1){
			top1++;
			array[top1]=x;
		}else{
			throw new StackOverflowError("Stack overflow erro!!");
		}
	}
	
	public int pop1(){
		if(top1>=0){
			return array[top1--];
		}else{
			return -1;
		}
	}
	
	public void push2(int x){
		if(top1<top2-1){
			top2--;
			array[top2]=x;
		}else{
			throw new StackOverflowError("Stack overflow erro!!");
		}
	}
	
	public int pop2(){
		if(top2<size){
			return array[top2++];
		}else{
			return -1;
		}
		
	}

}
