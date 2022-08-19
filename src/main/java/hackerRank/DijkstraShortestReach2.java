package hackerRank;

import graph.UndirectedWeightedGraph;
import graph.dijkstra.Vertex;

import java.util.*;

/*
 * Dijkstra's Shortest Path Algorithm
 * https://www.hackerrank.com/challenges/dijkstrashortreach/problem
 */
public class DijkstraShortestReach2 {
    static class Graph {
        private List<List<Integer>> adjacencyListWithWeight;
        private int V; // number of vertices
        private int E; // number of edges

        public Graph(int numberOfVertices, List<List<Integer>> adjacencyListWithWeight) {
            this.V = numberOfVertices;
            this.E = adjacencyListWithWeight.size();
            this.adjacencyListWithWeight = adjacencyListWithWeight;
        }

        public boolean isConnected(int vertex1, int vertex2) {
            for (List<Integer> edge : this.adjacencyListWithWeight) {
                if (edge.contains(vertex1) && edge.contains(vertex2)) {
                    return true;
                }
            }
            return false;
        }
    }

    /*
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n number of nodes
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER s  starting position
     */
    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        Graph graph = new Graph(n, edges);
        List<Integer> shortestPath = new ArrayList<>();

        Set<Vertex> settledNodes = new HashSet<>();
        Set<Vertex> unsettledNodes = new HashSet<>();

        return shortestPath;
    }

    public void evaluateDustanceAndPath(Integer adjacentNode, Integer sourceNode) {
    }

    public static void main(String[] args) {
    }
}
