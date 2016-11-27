package com.example.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class MyStack<T> {
	
	private static class MyStackNode<T>{
		private T data;
		private MyStackNode<T> next;
		
		public MyStackNode(T data){
			this.data=data;
		}
	}
	
	private MyStackNode<T> top;
	
	
	//Push
	
	public void push(T data){
		MyStackNode<T>item=new MyStackNode<T>(data);
		item.next=top;
		top=item;
	}
	
	//pop
	public T pop(){
		if(top == null){
			throw new EmptyStackException();
		}
		
		T item=top.data;
		top=top.next;
		return item;
	}
	
	public T peek(){
		if(top == null){
			throw new EmptyStackException();
		}
		
		return top.data;
	}
	
	public boolean isEmpty(){
		if(top==null){
			return true;
		}else{
			return false;
		}
	}
	
	/*======================Stack Puzzles=====================================*/
	/**
	 * This evaluates an expression if it is given in string
	 * @param expression
	 * @return
	 */
	public static int evaluateExpression(String expression){
	    //TODO:Validate for null
	    
	   //Split the expression in to tokens
	    char[]tokens=expression.toCharArray();
	    
	    //Init value stack
	    Stack<Integer>valueStack=new Stack<>();
	    
	    //Init operator stack
	    Stack<Character>charStack=new Stack<>();
	    
	    //Parse
	    for(int i=0;i<tokens.length;i++){
	      if(tokens[i]==' ')
	          continue;
	      
	      //If it is number push it in to the stack
	      if(tokens[i]>='0' && tokens[i]<='9'){
	        StringBuffer sBuf=new StringBuffer();
	        //If the number has more than one digit
	        while(i<tokens.length && tokens[i]>='0' 
	        		&& tokens[i]<='9'){
	            sBuf.append(tokens[i++]);
	        }
	        
	        valueStack.push(Integer.parseInt(sBuf.toString()));
	        continue;
	      }
	                        
	    //If it is '('
	     if(tokens[i]=='('){
	          charStack.push(tokens[i]);
	     }
	      
	    //If it is ')',then till opsStack top ==')',pop all expressions
	      //& values & put the cal value in value stack
	      
	     if(tokens[i]==')'){
	      while(charStack.peek()!='('){
	        char exp=charStack.pop();
	        int val1=valueStack.pop();
	        int val2=valueStack.pop();
	        int res=evaluate(exp,val1,val2);
	        valueStack.push(res);
	      }
	      charStack.pop();
	     
	     }
	      
	      // Current token is an operator.
	            else if (tokens[i] == '+' || tokens[i] == '-' ||
	                     tokens[i] == '*' || tokens[i] == '/')
	            {
	                // While top of 'ops' has same or greater precedence to current
	                // token, which is an operator. Apply operator on top of 'ops'
	                // to top two elements in values stack
	                while (!charStack.empty() && hasPrecedance(tokens[i], charStack.peek()))
	                  valueStack.push(evaluate(charStack.pop(), valueStack.pop(), valueStack.pop()));
	 
	                // Push current token to 'ops'.
	                charStack.push(tokens[i]);
	            }
	    }
	    
	    // Entire expression has been parsed at this point, apply remaining
	        // ops to remaining values
	        while (!charStack.empty())
	            valueStack.push(evaluate(charStack.pop(), valueStack.pop(), valueStack.pop()));
	 
	        // Top of 'values' contains result, return it
	        return valueStack.pop();
	  
	  }
	  
	  
	  
	  private static int evaluate(char op,int val1,int val2){
	  
	    switch(op){
	      case '+':
	        return val1+val2;
	      case '-':
	        return val1-val2;
	      case '*':
	        return val1*val2;
	      case '/':
	        if(val2==0)
	            throw new UnsupportedOperationException("Cannot divide by zero");
	        
	        return val1/val2;
	        
	      default:
	        return -1;
	        
	    }
	  }
	    
	    private static boolean hasPrecedance(char op1,char op2){
	      if(op2=='(' || op2==')')
	          return false;
	      if((op1=='*' || op1=='/') && (op2=='+')||op2=='-')
	          return false;
	      
	      return true;
	    
	    }
	    
	    
	    /**
	     * 1.Start putting all the expressions in the stack one by one
	     * 2.When you encounter ')',Check the top
	     * 	 2.1 If the top is '(',then duplicate exists
	     *   2.2 else,pop all the expressions until you get ')'
	     * 3.else push in to the stack
	     *   
	     * @param expression
	     */
	    
	    public static void findDuplicateParanthesis(String expression){
	   
	    	char [] tokens=expression.toCharArray();
	    	Stack<Character>opsStack=new Stack<Character>();
	    	
	    	for(Character ch:tokens){
	    		if(ch==')'){
	    			char top=opsStack.peek();
	    			if(top=='('){
	    				System.out.println("Duplicate found!!");
	    				return ;
	    			}else{
	    				while(top!='('){
	    					top=opsStack.peek();
	    					opsStack.pop();
	    				}
	    			}
	    		}else{
	    			opsStack.push(ch);
	    		}
	    	}
			System.out.println("Duplicate not found!!");

	    }
	    
	   public MyStack<Integer> sort(){
		   if(this.isEmpty()){
			   throw new EmptyStackException();
		   }
		   
		   MyStack<Integer>minStack=new MyStack<Integer>();
		   while(!this.isEmpty()){
			   int temp=(int) this.pop();
			   while(!minStack.isEmpty() && temp > minStack.peek()){
				   
			   }
		   }
		   return null;
	   }
	   
	   /**
	    * This is an inplace sorting algorithm to sort an exiting stack
	    * without using auxilary space
	    * Algo:
	    * 	1.Continously pop all the elements till the stack is empty
	    * 	2.Rearrange it based on the value
	    * 
	    * @param stack
	    * @return
	    */
	   public static MyStack<Integer> sort(MyStack<Integer> stack){
		   sortStack(stack);
		   return stack; 
	   }
	   
	   /**
	    * Continously pop all the elements till the stack is empty
	    * once it is done,rearrange
	    * @param stack
	    */
	   private static void sortStack(MyStack<Integer>stack){
		   if(stack.isEmpty()){
			   return ;
		   }else{
			   int x=stack.peek();
			   stack.pop();
			   sort(stack);
			   insertPoppedElements(x, stack);
		   }
	   }
	   
	   /**
	    * 1.Checks if the element to be inserted is > the current top
	    * 2.If yes,rearrange it recursively
	    * 3.If no,push it in to the stack
	    * @param x
	    * @param stack
	    */
	   
	   private static void insertPoppedElements(int x,MyStack<Integer>stack){
		   if(stack.isEmpty()){
			   stack.push(x);
		   }else if(x > stack.peek()){
			   int y=stack.peek();
			   stack.pop();
			   insertPoppedElements(y, stack);
		   }else{
			   stack.push(x);
		   }
	   }
	   
	   /**
	    * http://www.geeksforgeeks.org/the-stock-span-problem/
	    * http://code.geeksforgeeks.org/5zanGr
	    * @param prices
	    * @return
	    */
	   public static int [] getSpan(int [] prices){
		   MyStack<Integer>spanStack=new MyStack<Integer>();
		   int [] spanArray=new int[prices.length];
		   for(int i=0;i<prices.length;i++){
			   //By Default,it is 1
			   spanArray[i]=1;
			   
			   //If the current element in the array >=topMost element,then it ll obvipously
			   //be +1 greater than the span of topmost element
			   while(!spanStack.isEmpty() && prices[i]>=prices[spanStack.peek()]){
				   spanArray[i]=spanArray[i]+spanArray[spanStack.pop()];
			   }
			   
			   spanStack.push(i);
		   }
		   
		   return spanArray;
	   }
	   
	   
	   @Override
	public String toString() {
		   
		   MyStackNode<Integer>tempTop=(MyStackNode<Integer>) top;
		   StringBuilder stringBuilder=new StringBuilder();
		   stringBuilder.append("[");
		   while(tempTop!=null){
			   stringBuilder.append(String.valueOf(tempTop.data));
			   tempTop=tempTop.next;
			   if(tempTop!=null){
				   stringBuilder.append(", ");
			   }
		   }
		   stringBuilder.append("]");
		   
		  return stringBuilder.toString();
	}
	   
	
	   

}
