package codingExercises.graph.addEdge;

import java.util.ArrayList;
import java.util.HashMap;


public class Graph {

    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public HashMap<String, ArrayList<String>> getAdjList() {
        return adjList;
    }

    public void printGraph() {
        System.out.println(adjList);
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) == null || adjList.get(vertex2) == null) return false;

        adjList.get(vertex1).add(vertex2);
        adjList.get(vertex2).add(vertex1);

        return true;
    }

    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<String>());
            return true;
        }
        return false;
    }
}
