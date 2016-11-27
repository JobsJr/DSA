package com.example.stack;

public class MyMinStack extends MyStack<Integer> {
	MyStack<Integer>mMinStack;
	
	public MyMinStack(){
		mMinStack=new MyStack<Integer>();
	}
	
	@Override
	public void push(Integer data) {
		if(data<min()){
			mMinStack.push(data);
		}
		super.push(data);
	}
	
	@Override
	public Integer pop() {
		if(mMinStack!=null && !mMinStack.isEmpty()){
			int value=mMinStack.peek();
			if(value==min()){
				mMinStack.pop();
			}
		}
		return super.pop();
	}
	
	public int min(){
		if(mMinStack.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return mMinStack.peek();
		}
	}
	

}
