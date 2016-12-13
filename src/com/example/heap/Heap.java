package com.example.heap;


public class Heap {

	int[] array;
	/* ==========Number of elements============== */
	int count;
	/* ==========MAX SIZE of heap============== */
	int size;
	/* ==========Min heap or Max Heap============== */
	int type;

	public Heap(int capacity, int type) {
		size = capacity;
		this.type = type;
		array = new int[size];
	}

	/**
	 * Get Parent of at index
	 * The parent of any child always lies at
	 * (i-1)/2
	 * 
	 * TC:O(1)
	 * @param childIndex
	 * @return
	 * 
	 */
	public int getParent(int childIndex) {
		if (childIndex <= 0 || childIndex >= count) {
			return -1;
		}
		
		return (childIndex-1)/2;
	}
	
	/**
	 * Child of any node can be found either at
	 * 2i+1(Left) or 2i+2(Right)
	 *  TC:O(1)
	 * @param parentPosition
	 * @return
	 */
	public int getLeftChild(int parentPosition){
		int left=2*parentPosition+1;
		if(left > count){
			return -1;
		}
		return left;
	}
	
	public int getRightChild(int parentPosition){
		int right=2*parentPosition+2;
		if(right > count){
			return -1;
		}
		return right;
	}
	
	public int getMaximum(){
		if(this.count==0){
			return -1;
		}
		return array[0];
	}

}
