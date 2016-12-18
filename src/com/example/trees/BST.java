package com.example.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BST {
	BSTNode mRoot;
	
	public BST() {
		mRoot=null;
	}
	
	
	public void insert(int data){
		BSTNode newNode=new BSTNode(data);
		
		//If BST is empty,this is the root nigggaa!!
		if(mRoot==null){
			mRoot=newNode;
			return;
		}
		
		BSTNode currentNode=mRoot;	
		BSTNode parentNode=null;
		while(true){
			//Parent node always stays one step behind current node
			parentNode=currentNode;
			if(data < parentNode.data){//Go left
				//Check if there is left
				currentNode=currentNode.left;
				if(currentNode==null){//No left?You found the spot
					parentNode.left=newNode;
					return;
				}
				
			}else{
				currentNode=currentNode.right;
				if(currentNode==null){
					parentNode.right=newNode;
					return;
				}
			}
			
		}
	}
	
	
	public boolean find(int data){
		BSTNode current=mRoot;
		while(current!=null){
			if(current.data==data)
				return true;
			else if(current.data < data){
				current=current.right;
			}else{
				current=current.left;
			}
			
		}
		
		return false;
		
	}
		
		
	
	public void displayRoot(BSTNode root){
		if(root!=null){
			displayRoot(root.left);
			System.out.println(root.data);
			displayRoot(root.right);

		}
		
	}
	
	public BSTNode getRoot(){
		return mRoot;
	}
	
	/**
	 * Category:DFS
	 * Preorder:<Left><Root><Right>
	 * @param root
	 */
	public void parsePreOrder(BSTNode root){
		if(root == null)
			return;
		parsePreOrder(root.left);
		System.out.println(root.data);
		parsePreOrder(root.right);
	}
	
	/**
	 * Category:DFS
	 * Inorder:<Root><Left><Right>
	 * @param root
	 */
	public void parseInorder(BSTNode root){
		if(root == null){
			return;
		}
		
		System.out.println(root.data);
		parseInorder(root.left);
		parseInorder(root.right);

		
	}
	
	
	/**
	 * Category:DFS
	 * Postorder:<Left><Right><root>
	 * @param root
	 */
	
	public void parsePostOrder(BSTNode root){
		if(root ==null){
			return;
		}
		parseInorder(root.left);
		parseInorder(root.right);
		System.out.println(root.data);

	}
	
	/**
	 * Category:BFS
	 * @param root
	 */
	public void parseLevelOrder(BSTNode root){
		if(root==null){
			throw new IllegalArgumentException("Can't have an empty node");
		}
		
		Queue<BSTNode>queue=new LinkedList<BSTNode>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			BSTNode parseNode=queue.poll();
			System.out.println(parseNode.data);
			
			if(parseNode.left!=null)
				queue.add(parseNode.left);
			if(parseNode.right!=null)
				queue.add(parseNode.right);
		}
		
	}
	
	
	/**
	 * Height of tree:
	 * Longest route from a given node to any given leaf of a tree
	 * Height of tree=max(Height of left subtree,Height of right subtree)+1
	 * 
	 * TC:O(n) upper bound
	 */
	public int getHeight(BSTNode root){
		
		if(root==null)
			return -1;
		int leftHeight=getHeight(root.left);
		int rightHeight=getHeight(root.right);
		
		return maxHeight(leftHeight,rightHeight)+1;
		
	}
	
	private int maxHeight(int left,int right){
		return left >= right?left:right;
	}
	
	
	/**
	 * Check if two Binary trees are identical
	 */
	
	public boolean checkIdentical(BSTNode root1,BSTNode root2){
		//Will be true only when both of them are leafs
		//That mean's completion of tree traversal.If you have reached leaf in both the tree(Subtree's)
		//that means that particular tree(subtree) is identical
		if(root1==null && root2==null){
			return true;
		}
		
		//Will fail when one of the root is null or data is not proper
		if(root1!=null && root2!=null&& root1.data==root2.data){
			boolean isLeftTreeIdentical=checkIdentical(root1.left, root2.left);
			boolean isRightTreeIdentical=checkIdentical(root1.right, root2.right);
			return isLeftTreeIdentical && isRightTreeIdentical;
		}
		
		return false;
		
	}
	
	
	/**
	 * Checking number of leaves in a tree recursively for both
	 * left & right trees if they exist
	 */
	public int getLeafs(BSTNode root){
		if(root!=null && root.left==null && root.right==null)
			return 1;
		if(root!=null){
			return getLeafs(root.left)+getLeafs(root.right);
		}
		 return 0;
		
	}
	
	/**
	 * Create mirror image of a tree
	 * @param node
	 * @return
	 */
	public BSTNode mirrorTree(BSTNode node){
		if(node == null){
			return node;
		}
		
		BSTNode left=mirrorTree(node.left);
		BSTNode right=mirrorTree(node.right);
		
		node.left=right;
		node.right=left;
		
		return node;
		
	}
	
	/**
	 * Creating a BST with minimal height using sorted array:
	 * Just find the middle element,insert that in the tree
	 * Do it recursively for left & right
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public BSTNode createBalBST(int [] array,int start,int end){
		
		if(start > end){
			return null;
		}
		
		int mid=(start+end)/2;
		BSTNode bstNode=new BSTNode(array[mid]);
		
		bstNode.left=createBalBST(array, start, mid-1);
		bstNode.right=createBalBST(array, mid+1, end);
		
		return bstNode;
		
	}
	
	public ArrayList<ArrayList<BSTNode>> createNodeList(BSTNode root){
		if(root == null){
			throw new IllegalArgumentException("Cant have null root!!");
		}
		
		Queue<BSTNode>queue=new LinkedList<BSTNode>();
		queue.add(root);
		
		ArrayList<ArrayList<BSTNode>>nodeLists=new ArrayList<ArrayList<BSTNode>>();
		while(!queue.isEmpty()){
			BSTNode node=queue.poll();
			ArrayList<BSTNode>list=new ArrayList<BSTNode>();
			list.add(node);
			nodeLists.add(list);
			
			if(node.left!=null)
				queue.add(node.left);
			if(node.right!=null)
				queue.add(node.right);
		}
		
		return nodeLists;
	}
	
	/**
	 * Checks if BST is balanced.
	 * A BST is said to be balanced if,difference in left Subtree & right subtree is always <=1
	 * @param root
	 * @return
	 */
	public boolean isBalancedBT(BSTNode root){
		if(root==null)
			return true;
		
		//Check left Height
		int hLeft=getHeight(root.left);
		//Check Right Height
		int hRight=getHeight(root.right);
		
		//Do it recursively
		if(Math.abs(hLeft-hRight)<=1 && isBalancedBT(root.left) && isBalancedBT(root.right)){
			return true;
		}
		
		return false;
		
	}
	
	
	/**
	 * Check if a binary tree is BST
	 * @param root
	 * @return
	 */
	public boolean isBST(BSTNode root){
		
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	/**
	 * Recursively check for left & right
	 * @param root
	 * @param min
	 * @param max
	 * @return
	 */
	private boolean isBST(BSTNode root,int min,int max){
		if(root == null){
			return true;
		}
		
		if(root.data <=min || root.data >=max){
			return false;
		}
		
		//for a BT to be BST, lData < pData AND rData >pData
		//lData<-left node data
		//rData<-rightNode data,
		//pData<-root node data(parent)
		
		return isBST(root.left, min, root.data) &&
				isBST(root.right,root.data,max);
		
	}


}
