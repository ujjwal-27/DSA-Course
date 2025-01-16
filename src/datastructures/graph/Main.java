package datastructures.graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        System.out.println(graph.addVertex("A"));
        System.out.println(graph.addVertex("B"));
        System.out.println(graph.addVertex("C"));

        graph.addEdge("A", "B");
        graph.addEdge("C", "B");

        graph.removeEdge("A", "B");

        graph.printGraph();
    }
}
