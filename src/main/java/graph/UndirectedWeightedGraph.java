package graph;

import java.util.LinkedList;
import java.util.List;

public class UndirectedWeightedGraph {
    class Edge {
        int endVertix;
        int weight;
        public Edge(int endVertix, int weight) {
            this.endVertix = endVertix;
            this.weight = weight;
        }
    }

    private List<Edge>[] adjacencyList;
    private int V; // number of vertices
    private int E; // number of edges

    public UndirectedWeightedGraph(int numberOfVertices) {
        this.V = numberOfVertices;
        this.E = 0;
        this.adjacencyList = new LinkedList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            this.adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int vertex1, int vertex2, int weight) {
        this.adjacencyList[vertex1].add(new Edge(vertex2, weight));
        this.adjacencyList[vertex2].add(new Edge(vertex1, weight));
        this.E++;
    }

    public boolean isConnected(int vertex1, int vertex2) {
        for (Edge edge : this.adjacencyList[vertex1]) {
            if (edge.endVertix == vertex2) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vertices: " + this.V + ", Edges: " + this.E + "\n");
        for (int i = 0; i < this.V; i++) {
            sb.append(i + ": ");
            for (Edge edge : this.adjacencyList[i]) {
                sb.append(edge.endVertix + "->" + edge.weight + " | ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        UndirectedWeightedGraph graph = new UndirectedWeightedGraph(5);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 8);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 1, 5);
        graph.addEdge(1, 2, 4);
        System.out.println(graph);
        System.out.println(graph.isConnected(2, 4));
        System.out.println(graph.isConnected(4, 1));
    }
}
