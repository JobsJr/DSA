package com.example.trees;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		BST binarySearchTree=new BST();
			
		
			binarySearchTree.insert(5);
			binarySearchTree.insert(22);
			binarySearchTree.insert(21);
			binarySearchTree.insert(1);
			
			//binarySearchTree.displayRoot(binarySearchTree.getRoot());
			
			//System.out.println(binarySearchTree.find(21));
			
			/****************Print PRE ORDER*********************/
			//binarySearchTree.parsePreOrder(binarySearchTree.getRoot());
			
			/****************Print InORDER*********************/
			//binarySearchTree.parseInorder(binarySearchTree.getRoot());
			

			/****************Print postOrder*********************/
			//binarySearchTree.parsePostOrder(binarySearchTree.getRoot());
			
			/****************Print Levelorder*********************/
//			binarySearchTree.parseLevelOrder(binarySearchTree.getRoot());
//			
//			System.out.println("Height of the tree: "+binarySearchTree.getHeight(binarySearchTree.mRoot));
//			
//			BST binarySearchTree1=new BST();
//			
//			
//			binarySearchTree1.insert(5);
//			binarySearchTree1.insert(22);
//			binarySearchTree1.insert(21);
//			binarySearchTree1.insert(24);
//			binarySearchTree1.insert(1);
//			
//			System.out.println("Are  Trees identical: "+binarySearchTree.checkIdentical(binarySearchTree.getRoot(), binarySearchTree1.getRoot()));
//			
//			System.out.println("Number of leafs in Tree "+binarySearchTree1.getLeafs(binarySearchTree1.getRoot()));
//			
			
			//binarySearchTree.parseInorder(binarySearchTree.mirrorTree(binarySearchTree.getRoot()));
			
			int [] array=new int [] {1,2,3,4,5};
			BST bst=new  BST();
			int length=array.length;
			
			BSTNode rootNode=bst.createBalBST(array, 0, length-1);
			
			binarySearchTree.parsePreOrder(rootNode);
			System.out.println("Height is "+binarySearchTree.getHeight(rootNode));
			
			ArrayList<ArrayList<BSTNode>>nodelists=binarySearchTree.createNodeList(rootNode);
			
			if(nodelists!=null && !nodelists.isEmpty()){
				for(ArrayList<BSTNode>nodeList:nodelists){
					for(BSTNode node:nodeList){
						System.out.print(node.data);
						System.out.print(" ");
					}
					System.out.println("/********/");
				}
			}
			
			
			
			
	}
}
