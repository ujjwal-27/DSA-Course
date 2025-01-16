package datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    // An empty HashMap 'adjList' as instance variable, which accept a 'String' as 'key' (vertex of Graph), and 'List of String' as its respective 'value' (other vertices with which the vertex has edge with)
    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    /**
     * First, the existence of vertex1 and vertex2 is checked. If it doesn't exist, return false.
     * If it exits, add 'vertex1' to the ArrayList of 'vertex2' and vice versa.
     * Then, return true.
     * @param vertex1 String
     * @param vertex2 String
     * @return Boolean True/False
     */
    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }

        return false;
    }

    /**
     * First, the existence of vertex is checked. If it exists, return false.
     * If it doesn't exist, add the vertex in the HashMap 'adjList', with an empty ArrayList as value.
     * Then, return true.
     * @param vertex String
     * @return Boolean True/False
     */
    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<>());
            return true;
        }

        return false;
    }

    /**
     * First, the existence of vertex1 and vertex2 is checked. If it doesn't exist, return false.
     * If it exits, remove 'vertex1' from the ArrayList of 'vertex2' and vice versa.
     * Then, return true.
     * @param vertex1 String
     * @param vertex2 String
     * @return Boolean True/False
     */
    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }

        return false;
    }

    /**
     * Let's assume, vertex "A" is to be removed.
     * Since the edges in the graph is bidirectional, if a vertex "A" has edge with other vertices, then those vertices will also have edge with the vertex "A".
     * Based on this, first the vertex is checked if it exists or not. If it doesn't exist, return false.
     * If it exists, for-loop is executed on the list of vertices (otherVertex) with which the vertex "A" has edge with.
     * Then, on each iteration, vertex "A" is removed from those vertices.
     * Finally, the vertex "A" is removed, and return true.
     * @param vertex One of the vertices of Graph (a key in HashMap 'adjList')
     * @return Boolean True/False
     */
    public boolean removeVertex(String vertex) {
        if (adjList.get(vertex) != null) {
//            adjList.get(vertex).forEach((String edge) -> {
//                adjList.get(edge).remove(vertex);
//            });

            for (String otherVertex: adjList.remove(vertex)) {
                adjList.get(otherVertex).remove(vertex);
            }

            adjList.remove(vertex);
            return true;
        }

        return false;
    }

    /**
     * Print HashMap 'adjList'.
     */
    public void printGraph() {
        System.out.println(adjList);
    }
}
