package dataStructures.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    // Within a graph, there are edges and vertices
    // Edges can be unidirectional or bidirectional.
    // Graphs can be represented by -
    // 1. Adjacency Matrix -
    //      It will always have diagonal elements as "0"
    //      If all of the edges are bidirectional, we will have symmetric matrix
    //      Weights can be defined within the matrix.
    //      Complexity - 
    //          a. Generic - O(|V|^2)   - Space Complexity
    //          b. Adding a vertex - O(|V|^2)
    //          c. Adding an edge - O(1)
    //          d. Removing an edge - O(1)
    //          e. Removing a vertex - O(|V|^2)
    // 2. Hash Map / Adjacency List - 
    //      Vertice - [Vertices] -> key - value pair
    //      Complexity - 
    //          a. Generic - O(|V|+|E|) - Space Complexity
    //          b. Adding a vertex - O(1)
    //          c. Adding an edge - O(1)
    //          d. Removing an edge - O(|E|)
    //          e. Removing a vertex - O(|V|+|E|)
    // Adjacency List is more advantages from space complexity Perspective

    // Following code is for bidirectional edges

    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public void printGraph() {
        System.out.println(adjList);
    }

    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<String>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        if (adjList.get(vertex) != null) {
            for (String otherVertex : adjList.get(vertex)) {
                adjList.get(otherVertex).remove(vertex);
            }
            adjList.remove(vertex);
            return true;
        }
        return false;
    }
}
