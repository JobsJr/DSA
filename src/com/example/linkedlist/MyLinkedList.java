package com.example.linkedlist;

import java.util.HashSet;

public class MyLinkedList<T> {
	//Head information
	private Node<T> headnode;
	
	//Size of the linked list
	private int size;
	
	
	
	//Add Functionality(by default append)
	public void add(T data){
		Node<T>newNode=new Node<T>();
		newNode.setData(data);
		
		//Check if head is null
		//if no,append it to last node
		if(headnode!=null){
			Node<T>tempNode=headnode;
			while(tempNode.getNext()!=null){
				tempNode=tempNode.getNext();
			}
			tempNode.setNext(newNode);
		}else{
			headnode=newNode;
		}
		size++;
	}
	//Delete
	
	//Check size
	public int size(){
		return size;
	}
	
	//print
	public void print(){
		
		System.out.println("/*******************/");
		if(headnode!=null){
			Node<T>tempNode=headnode;
			while(tempNode!=null){
				System.out.println(tempNode.getData());
				tempNode=tempNode.getNext();
			}	
		}else{
			System.out.println("Empty list!!!");
		}
		System.out.println("/*******************/");

		
	}
	
	
	/**
	 * 
	 * @param data
	 * @return
	 * Complexity:O(n)
	 */
	
	public Node deleteNode(T data){
		//Check if headnode is null
		//n
		if(headnode==null){
			System.out.println("Empty List");
			return headnode;
		}
		
		//Check if headnode has the data
		//n
		if(headnode.getData()==data){
			headnode=headnode.getNext();
			return headnode;
		}
		Node tempNode=headnode;
		
		
		while(tempNode.getNext()!=null){
			if(tempNode.getNext().getData()==data){
				tempNode.setNext(tempNode.getNext().getNext());
				if(size>0)
					size--;
				break;
			}
			tempNode=tempNode.getNext();
		}
		
		return headnode;
	}
	
	public void removeDups(){
		if(headnode==null){
			System.out.println("Empty list!!!");
			return;
		}
		
		Node fastNode=headnode;
		Node slowNode=null;
		
		HashSet<T>bufferSet=new HashSet<T>();
		
		while(fastNode!=null){
			if(bufferSet.add((T)(fastNode.getData()))){
				slowNode=fastNode;
			}else{
				slowNode.setNext(slowNode.getNext().getNext());
			}
			
			fastNode=fastNode.getNext();
		}
		
	}
	
	
	public void findNodeAt(int positionFromLast){
		if(headnode==null){
			System.out.println("Empty lsit!!!");
			return;
		}
		
		if(positionFromLast<0){
			System.out.println("Invalid Value");
			return;
		}
		
		int length=0;
		Node tempNode=headnode;
		while(tempNode!=null){
			tempNode=tempNode.getNext();
			length++;
		}
		
		tempNode=headnode;
		int hops=length-positionFromLast;
		
		if(hops < 0){
			System.out.println("Invalid Value!!");
			return;
		}
		
		for(int i=0;i<hops-1;i++){
			tempNode=tempNode.getNext();
		}
		
		System.out.println(""+tempNode.getData());

	}
	
}
