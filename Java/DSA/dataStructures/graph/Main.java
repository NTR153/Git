package dataStructures.graph;

public class Main {
    public static void main(String[] args) {
        Graph tempGraph = new Graph();
        tempGraph.addVertex("A");
        tempGraph.addVertex("B");
        tempGraph.addEdge("A", "B");
        // tempGraph.removeEdge("A", "B");
        tempGraph.removeVertex("A");
        tempGraph.printGraph();
    }
}
