package com.example.linkedlist;

public class TestLinkedList {

	public static void main(String[] args) {
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();

		// *******************Removing Duplicate************************//
		// TC1:
		// myLinkedList.add(1);
		// myLinkedList.add(2);
		// myLinkedList.add(2);
		// myLinkedList.add(3);
		// myLinkedList.add(4);
		//
		// myLinkedList.removeDups();
		//
		// myLinkedList.print();

		// TC2:
		// myLinkedList.add(21);
		// myLinkedList.add(21);
		// myLinkedList.add(22);
		// myLinkedList.add(33);
		// myLinkedList.add(44);
		//
		// myLinkedList.removeDups();
		// myLinkedList.print();

		// TC3:
		// myLinkedList.add(21);
		// myLinkedList.add(21);
		// myLinkedList.add(21);
		// myLinkedList.add(21);
		// myLinkedList.add(21);
		//
		// myLinkedList.removeDups();
		// myLinkedList.print();

		// *******************Removing Duplicate************************//

		// *******************Nth node from last************************//

		// TC:1
		// myLinkedList.add(1);
		// myLinkedList.add(2);
		// myLinkedList.add(3);
		// myLinkedList.add(4);
		// myLinkedList.add(5);
		//
		//
		// myLinkedList.findNodeAt(3);
		// myLinkedList.findNodeAt(0);
		// myLinkedList.findNodeAt(100);
		// myLinkedList.findNodeAt(4);

		// *******************Nth node from last************************//

		// *******************Palindrome************************//
		// *******************Palindrome************************//

		/************************* Printing a list in reverse order ***************/

		myLinkedList.add(0);
		myLinkedList.add(2);
		myLinkedList.add(4);
		myLinkedList.add(6);
		myLinkedList.add(8);

		// MyLinkedList<Integer> newList=new MyLinkedList<Integer>();
		// newList.add(1);
		// newList.add(3);
		// newList.add(5);
		//
		// myLinkedList.mergeLinkedLists(myLinkedList.getHeadNode(),
		// newList.getHeadNode());
		// myLinkedList.print();
		//

		/************************* Printing a list in reverse order ***************/

		System.out
				.println("/*===============Rearranging list in a specific way====================*/");

		myLinkedList.reArrangeList(myLinkedList.getHeadNode());

	}

}
