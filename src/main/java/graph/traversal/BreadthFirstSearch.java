package graph.traversal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void traverse(Vertex start) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current.label);
                for (Vertex neighbour : current.getNeighbours()) {
                    if (!neighbour.isVisited()) {
                        queue.add(neighbour);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");
        Vertex v6 = new Vertex("6");

        v0.setNeighbours(Arrays.asList(v1, v5, v6));
        v1.setNeighbours(Arrays.asList(v3, v4, v5));
        v4.setNeighbours(Arrays.asList(v2, v6));
        v6.setNeighbours(Arrays.asList(v0));

        traverse(v0);
    }
}
