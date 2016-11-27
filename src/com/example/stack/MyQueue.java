package com.example.stack;

public class MyQueue {
	MyStack<Integer>inStack=new MyStack<Integer>();
	MyStack<Integer>outStack=new MyStack<Integer>();
	
	public void enQueue(int data){
		inStack.push(data);
	}
	
	public int deQueue(){
		
		if(outStack.isEmpty()){
			while(!inStack.isEmpty()){
				outStack.push(inStack.pop());
			}
		}
		
		if(!outStack.isEmpty()){
			return outStack.pop();
		}else{
			return -1;
		}
	}

}
