package com.example.heap;

/**
 * Max Heap implementation
 * 
 * @author rajeevkr
 *
 */
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
	 * Get Parent of at index The parent of any child always lies at (i-1)/2
	 * 
	 * TC:O(1)
	 * 
	 * @param childIndex
	 * @return
	 * 
	 */
	public int getParent(int childIndex) {
		if (childIndex <= 0 || childIndex >= count) {
			return -1;
		}

		return (childIndex - 1) / 2;
	}

	/**
	 * Child of any node can be found either at 2i+1(Left) or 2i+2(Right)
	 * TC:O(1)
	 * 
	 * @param parentPosition
	 * @return
	 */
	public int getLeftChild(int parentPosition) {
		int left = 2 * parentPosition + 1;
		if (left > count) {
			return -1;
		}
		return left;
	}

	public int getRightChild(int parentPosition) {
		int right = 2 * parentPosition + 2;
		if (right > count) {
			return -1;
		}
		return right;
	}

	public int getMaximum() {
		if (this.count == 0) {
			return -1;
		}
		return array[0];
	}

	/**
	 * 
	 * @return
	 */
	public int delete() {
		if (this.count == 0) {
			return -1;
		}

		// Copy the first element
		int temp = array[0];
		array[0] = array[count - 1];
		count--;

		percolateDown(0);
		return temp;
	}

	public void insert(int data) {
		if (count == size) {
			resizeHeap();
		}
		count++;
		int i = count - 1;

		// Percolate up,sort of
		while (i > 0 && data > array[getParent(i)]) {
			// If value @ parent < the data to be inserted,
			// then it violates heaps(max) property.So move parent to child &
			array[i] = array[getParent(i)];

			//make child the parent
			i = getParent(i);
		}

		array[i] = data;

	}

	private void resizeHeap() {
		int[] copyOfArray = new int[size];
		System.arraycopy(array, 0, copyOfArray, count - 1, count);
		array = new int[size * 2];
		for (int i = 0; i < copyOfArray.length; i++) {
			array[i] = copyOfArray[i];
		}
		size *= 2;
		copyOfArray = null;
	}
	

	private void percolateDown(int index) {
		// Determine left & right children
		int leftChild = getLeftChild(index);
		int rightChild = getRightChild(index);

		// Determine the highest among the child & parents
		int max = index;
		if (leftChild >= -1 && array[index] < array[leftChild]) {
			max = leftChild;
		}
		if (rightChild >= -1 && array[max] < array[rightChild]) {
			max = rightChild;
		}

		// Swap
		if (max != index) {
			swap(array, index, max);
			percolateDown(max);
		}

	}
	
	/**
	 * In-place version of max heapifying
	 * @param array
	 * @param index
	 */
	private void percolateDown(int []array,int index){
		//Determine left & Right child
		int leftChild=getLeftChild(index);
		int rightChild=getRightChild(index);
		
		//Determine the highest among parent & children
		int max=index;
		if (leftChild > -1 && array[index] < array[leftChild]) {
			max = leftChild;
		}
		if (rightChild >-1 && array[max] < array[rightChild]) {
			max = rightChild;
		}

		//Swap 
		if(max!=index){
			swap(array, index, max);
			percolateDown(array, max);
		}
				
	}
	
	private void swap(int []arr,int x,int y){
		arr[x]=arr[x]^arr[y];
		arr[y]=arr[x]^arr[y];
		arr[x]=arr[x]^arr[y];
	}
	
	
	//We shouldn't bother about leafs.Start
	//heapifying from parents
	private void buildHeap(int []array){
		int n=array.length;
		
		for(int i=(n-1)/2;i>=0;i--){
			percolateDown(array, i);
		}
	}
	
	private void buildHeap(int array[],Heap heap){
		int n=array.length;
		//If the array length > capacity
		if(n>=size){
			resizeHeap();
		}
		
		for(int i=0;i<n;i++){
			this.array[i]=array[i];
		}
		
		for(int i=(n-1)/2;i>=0;i--){
			percolateDown(i);
		}
	}
	
	
	public void heapSort(int [] array ){
		//Build the heap with the array
		buildHeap(array);
		
		int n=array.length;
		
		//Heapify
		for(int i=n-1;i>=0;i--){
			//Swap with topmost
			swap(array, 0, i);
			percolateDown(array, i);
		}
	}
	
	

}
