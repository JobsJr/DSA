package com.example.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
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
	/**
	 * Checks if a Graph is Cyclic by checking if it has got any back edges
	 * Src:http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
	 * 
	 * @return
	 */
	public boolean isCyclic(){
		boolean [] visited=new boolean[mVertexCount];
		boolean [] recStack=new boolean[mVertexCount];
		
		for(int i=0;i<mVertexCount;i++){
			visited[i]=false;
			recStack[i]=false;
		}
		
		for(int i=0;i<mVertexCount;i++){
			if(!visited[i]){
				if(isCyclicUtil(i, visited, recStack)){
					return true;
				}
			}
		}
		return false;
	}
	
	
	/**
	 * 1.This Util method recursively checks if the node has already been visited
	 * 		1.1 if yes,then check if it is there in recursion stack
	 * 			1.1.1 if yes,then it is cyclic
	 * 		1.2 If no, then check for its adjacent nodes in a similar way
	 * 
	 * This is Based on DFS
	 * 
	 * @param node
	 * @param visited
	 * @param recStack
	 * @return
	 */
	private boolean isCyclicUtil(int node,boolean [] visited,boolean [] recStack){
		visited[node]=true;
		recStack[node]=true;
		ArrayList<Integer>adjacentNodes=mAdjacencyMap.get(node);
		if(adjacentNodes!=null){
			Iterator<Integer>listIterator=adjacentNodes.listIterator();
			while(listIterator.hasNext()){
				int i=listIterator.next();
				if(!visited[i] && isCyclicUtil(i, visited, recStack)){
					return true;
				}
				
				//Base Condition
				if(recStack[i]){
					return true;
				}
			}
		}
		
		recStack[node]=false;//Reset everything,so that next iteration can use this
		return false;
	}
	
	//=============================Dijkstras Algo(START)============================//
	
	/**
	 * Fetches the node with the minimum distance value & is not already
	 * visited
	 * @param visited
	 * @param distance
	 * @return
	 */
	
	private int getMinDistanceIndex(boolean []visited,int []distance){
		int minIndex=-1,minValue=Integer.MAX_VALUE;
		for(int i=0;i<visited.length;i++){
			if(!visited[i] && distance[i]<minValue){
				minIndex=i;
				minValue=distance[i];
			}
		}
		return minIndex;
		
	}
	
	/**
	 * Find Shortest path from src to all other nodes
	 * Algo:Dijkstra's
	 * http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
	 * https://www.youtube.com/watch?v=pVfj6mxhdMw
	 * @param graph
	 * @param src
	 */
	public void dijSktrasSp(int [][]graph,int src){
		boolean [] visited=new boolean[mVertexCount];
		int [] distance=new int[mVertexCount];
		
		//Initialize distance & visited array
		for(int i=0;i<mVertexCount;i++){
			visited[i]=false;
			distance[i]=Integer.MAX_VALUE;
		}
		
		//Start with src.Since dist of src to src is 0
		//This will be the trigger,so initiate it in the beginning itself
		distance[src]=0;
		
		for(int i=0;i<mVertexCount;i++){
			int u=getMinDistanceIndex(visited, distance);
			//For i=0,it u will be src
			visited[u]=true;
			
			for(int v=0;v<mVertexCount;v++){
				if(!visited[v]
				&& graph[u][v]!=0
				&& distance[u]+graph[u][v]<distance[v]){
					distance[v]=distance[u]+graph[u][v];
				}
			}
			
		}
		printDistanceFromSrc(src, distance);
		
	}
	
	private void printDistanceFromSrc(int src,int [] distance){
		System.out.println("Node"+"\t"+"Shortest Distance from Src "+src);
		
		for(int i=0;i<distance.length;i++){
			System.out.println(i+"\t"+distance[i]);
		}
	}
	
	//=============================Dijkstras Algo(END)============================//
	
	
	/**
	 * Check if a route exists between Src to dest in a graph
	 * Algo:simple BFS
	 * TC:O(V+E)
	 * 
	 * @param src
	 * @param destination
	 * @return
	 */
	public boolean isRouteExists(int src,int destination){
		boolean []visited=new boolean[mVertexCount];
		
		Queue<Integer>queue=new LinkedList<Integer>();
		
		//Initialize
		for(int i=0;i<mVertexCount;i++){
			visited[i]=false;
		}
		
		queue.add(src);
		visited[src]=true;
		
		while(!queue.isEmpty()){
			int u=queue.poll();
			
			List<Integer>adjNodes=mAdjacencyMap.get(u);
			if(!adjNodes.isEmpty()){
				Iterator<Integer>iterator=adjNodes.listIterator();
				while(iterator.hasNext()){
					int v=iterator.next();
					if(visited[v] && v==destination){
						return true;
					}else{
						visited[v]=true;
						queue.add(v);
					}
				}
			}
		}
		
		return false;
	}
	
	
	

}
