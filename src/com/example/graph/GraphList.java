package com.example.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class GraphList {
	private Map<Integer, ArrayList<Integer>>mAdjacencyMap;
	private int mVertexCount;
	
	public GraphList(int vertexCount){
		this.mVertexCount=vertexCount;
		mAdjacencyMap=new HashMap<Integer, ArrayList<Integer>>();
		for(int i=0;i<mVertexCount;i++){
			mAdjacencyMap.put(i, new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int source,int destination){
		if(source<mVertexCount && destination<mVertexCount){
			List<Integer>sourceList=mAdjacencyMap.get(source);
			sourceList.add(destination);
			
			//Comment these two lines for directed graph
//			List<Integer>destinationList=mAdjacencyMap.get(destination);
//			destinationList.add(source);
		}
	}
	
	public ArrayList<Integer> getEdges(int source){
		if(source<mAdjacencyMap.size()){
			return mAdjacencyMap.get(source);
		}
		return null;
	}
	
	public Map<Integer, ArrayList<Integer>> getMap(){
		return mAdjacencyMap;
	}

	/**
	 * Depth first search
	 * @param startVertex
	 */
	public void dfs(int startVertex){
		//Initialize visited array
		boolean [] visited=new boolean[mVertexCount];
		
		//Initialize stack
		Stack<Integer>nodeStack=new Stack<Integer>();
		
		//Mark the vertex as true
		visited[startVertex]=true;
		
		
		//display start node
		System.out.println(startVertex);
		
		//Push the start vertex
		nodeStack.push(startVertex);

		
		
		//Until the stack is empty
		while(!nodeStack.isEmpty()){
			//Get the unvisited vertex of the recently visited node
			int unvisitedVertex=getUnvisitedVertex(nodeStack.peek(), visited);
			
			
			if(unvisitedVertex==-1){
				//If no adjacent nodes found
				nodeStack.pop();
			}else{
				//Mark that node as true
				visited[unvisitedVertex]=true;
				//Display it
				System.out.println(unvisitedVertex);
				//Push it in to node
				nodeStack.push(unvisitedVertex);
			}
		}
		
	}
	
	
	/**
	 * BFS in Graph is very similar to that of BFS(level order)in trees,
	 * except we need to handle cycles by using a visited array
	 * 
	 * @param s
	 */
	
	public void BFS(int s){
		//Create & Initialize visited array
		boolean [] visited=new boolean[mVertexCount];
		
		//Create a Queue
		Queue<Integer>nodeQueue=new LinkedList<Integer>();
		
		visited[s]=true;
		nodeQueue.add(s);
		
		while(!nodeQueue.isEmpty()){
			s=nodeQueue.poll();
			System.out.println(s);
			
			//Get all the adjacent vertices of s & mark it is as
			//visited & then push it in to Queue
			Iterator<Integer>iterator=getEdges(s).listIterator();
			while(iterator.hasNext()){
				int n=iterator.next();
				if(!visited[n]){
					visited[n]=true;
					nodeQueue.add(n);
				}
				
			}
			
		}	
		
	}
	
	
	
	
	/**
	 * Get the unvisited vertex of a node
	 * @param vertex
	 * @param visited
	 * @return
	 */
	private int getUnvisitedVertex(int vertex,boolean [] visited){
		for(int i=0;i<mVertexCount;i++){
			if(getEdges(vertex).contains(i) &&visited[i]==false ){
				int index=getEdges(vertex).indexOf(i);
				return getEdges(vertex).get(index);
			}
		}
		
		return -1;
	}
	
	
	/**
	 * Topological sort can be applied only on DAG
	 * Modified version of DFS is used
	 * 
	 */
	public void toplogicalSort(){
		boolean [] visited=new boolean[mVertexCount];
		Stack<Integer>stack=new Stack<Integer>();
		
		for(int i=0;i<mVertexCount;i++){
			//Start sorting one by one 
			if(!visited[i]){
			
				topologicalSort(i,visited,stack);
			}
		}
		
		System.out.println("/===========Topological Sort============/");
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+"-->");
		}
	}
	
	
	
	/**
	 * 	Call this recursively so that dependencies are removed
	 *	from each node.So,when a node is put in the stack,it is that
	 *	node on which no other node has dependency
	 
	 * @param v
	 * @param visited
	 * @param stack
	 */
	private void topologicalSort(int v,boolean [] visited,Stack<Integer> stack){
		visited[v]=true;
		
		ArrayList<Integer>adjacentNodes=mAdjacencyMap.get(v);
		if(adjacentNodes!=null){
			Iterator<Integer>listIterator=adjacentNodes.listIterator();
			while(listIterator.hasNext()){
				int i=listIterator.next();
				if(!visited[i]){
					topologicalSort(i,visited,stack);
				}
			}

		}
		stack.push(v);
	}
}
