package graph;

import java.util.LinkedList;
import java.util.List;

public class UndirectedGraph {
    private List<Integer>[] adjacencyList;
    private int V; // number of vertices
    private int E; // number of edges

    public UndirectedGraph(int numberOfVertices) {
        this.V = numberOfVertices;
        this.E = 0;
        this.adjacencyList = new LinkedList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            this.adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int vertex1, int vertex2) {
        this.adjacencyList[vertex1].add(vertex2);
        this.adjacencyList[vertex2].add(vertex1);
        this.E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Number of vertices: " + this.V + ", number of edges: " + this.E + "\n");
        for (int i = 0; i < this.V; i++) {
            sb.append(i + ": ");
            for (int vertex : this.adjacencyList[i]) {
                sb.append(vertex + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);
        graph.addEdge(1, 2);
        System.out.println(graph);
    }
}


