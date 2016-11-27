package com.example.graph;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		int source , destination;
        int number_of_edges,number_of_vertices;
        int count = 1;
        Scanner scan = new Scanner(System.in);
        try
        {
            /* Read the number of vertices and edges in graph */
            System.out.println("Enter the number of vertices and edges in graph");
            number_of_vertices = scan.nextInt();
            number_of_edges = scan.nextInt();
            GraphList adjacencyList = new GraphList(number_of_vertices);

            /* Reads the edges present in the graph */
            System.out.println("Enter the edges in graph Format : <source index> <destination index>");
            while (count <= number_of_edges)
            {
                source = scan.nextInt();
                destination = scan.nextInt();
                adjacencyList.addEdge(source, destination);
                count++;
            }
            
            
            /* Reads the node from which you want to traverse */
           /* System.out.println("Enter the node from which you want to traverse");
            	int startNode=scan.nextInt();
            	
                System.out.println("==============DFS=============");
            	//DFS
            	adjacencyList.dfs(startNode);
            	
                System.out.println("==============BFS=============");
            	//BFS
            	adjacencyList.dfs(startNode);*/
            
            adjacencyList.toplogicalSort();
            
           
         } 
         catch(InputMismatchException inputMismatch)
         {
             System.out.println("Error in Input Format. \nFormat : <source index> <destination index>");
         }
         scan.close();
    }
	

}
