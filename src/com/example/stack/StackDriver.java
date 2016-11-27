package com.example.stack;

import java.util.Arrays;
import java.util.Stack;

public class StackDriver {

	public static void main(String[] args) {

		//Evaluate an expression
		System.out.println(""+MyStack.evaluateExpression("10 + 2 * 6"));

		MyStack.findDuplicateParanthesis("((a+b)+((c+d)))");
		
		MyMinStack minStack=new MyMinStack();
		minStack.push(2);
		minStack.push(3);
		minStack.push(1);
		
		System.out.println("Min-->"+minStack.min());
		
		minStack.push(10);
		
		
		System.out.println("Min-->"+minStack.min());
		
		minStack.pop();
		System.out.println("Min-->"+minStack.min());


		MyQueue myQueue=new MyQueue();
		
		myQueue.enQueue(1);
		myQueue.enQueue(2);
		myQueue.enQueue(3);
		myQueue.enQueue(4);

		System.out.println(myQueue.deQueue());
		System.out.println(myQueue.deQueue());
		
		MyStack<Integer>stack=new MyStack<Integer>();
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		
		stack=MyStack.sort(stack);
		System.out.println(stack);
		
		int price[] = {100, 100, 100, 80, 60, 70, 160, 75, 85};
		System.out.println(Arrays.toString(MyStack.getSpan(price)));

	}
	
}
