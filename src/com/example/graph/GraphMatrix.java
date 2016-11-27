package com.example.graph;


/**
 * Undirected graph rep in Adjacency matrix
 * This is suitable only if Graph is dense
 * Because if it is sparse,lots of memory is wasted
 * as it consumes O(v2) memory
 * 
 * @author rajeevkr
 *
 */
public class GraphMatrix {
	private boolean [][]mAdjMatrix;
	private int mVertextCount;
	
	public GraphMatrix(int vertexCount){
		mVertextCount=vertexCount;
		mAdjMatrix=new boolean[mVertextCount][mVertextCount];
	}
	
	
	public void addEdge(int i,int j){
		if(i>=0 && i<mVertextCount && j>=0 && j<mVertextCount){
			mAdjMatrix[i][j]=true;
			mAdjMatrix[j][i]=true;
		}
	}
	
	public void removeEdge(int i,int j){
		if(i>=0 && i<mVertextCount && j>=0 && j<mVertextCount){
			mAdjMatrix[i][j]=false;
			mAdjMatrix[j][i]=false;
		}
	}
	
	public boolean hasEdge(int i,int j){
		
		if(i>=0 && i<mVertextCount && j>=0 && j<mVertextCount){
			return mAdjMatrix[i][j];
		}
		return false;
	}

}
