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
            
           // adjacencyList.toplogicalSort();
          //  System.out.println("Is it Cyclic: "+adjacencyList.isCyclic());
            
            
            /* Let us create the example graph discussed above */
//            int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
//                                       {4, 0, 8, 0, 0, 0, 0, 11, 0},
//                                       {0, 8, 0, 7, 0, 4, 0, 0, 2},
//                                       {0, 0, 7, 0, 9, 14, 0, 0, 0},
//                                       {0, 0, 0, 9, 0, 10, 0, 0, 0},
//                                       {0, 0, 4, 14, 10, 0, 2, 0, 0},
//                                       {0, 0, 0, 0, 0, 2, 0, 1, 6},
//                                       {8, 11, 0, 0, 0, 0, 1, 0, 7},
//                                       {0, 0, 2, 0, 0, 0, 6, 7, 0}
//                                      };
//            
//            GraphList graphList=new GraphList(9);
//            graphList.dijSktrasSp(graph, 0);
            
            System.out.println("Enter the src & destination in graph whose route to be found out in Format : <source index> <destination index>");
            int src=scan.nextInt();
            int dest=scan.nextInt();
            
            System.out.println(adjacencyList.isRouteExists(src,dest));
            
            
           
         } 
         catch(InputMismatchException inputMismatch)
         {
             System.out.println("Error in Input Format. \nFormat : <source index> <destination index>");
         }
         scan.close();
    }
	

}
