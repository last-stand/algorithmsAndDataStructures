package graph.traversal;

import java.util.Arrays;
import java.util.Stack;

public class DepthFirstSearch {
    public static void traverse(Vertex start) {
        Stack<Vertex> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            Vertex current = stack.pop();
            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current.getLabel());
                for (Vertex neighbour : current.getNeighbours()) {
                    if (!neighbour.isVisited()) {
                        stack.push(neighbour);
                    }
                }
            }
        }
    }

    public static void traverseRecursively(Vertex start) {
        start.setVisited(true);
        System.out.println(start.getLabel());
        for (Vertex neighbour : start.getNeighbours()) {
            if (!neighbour.isVisited()) {
                traverseRecursively(neighbour);
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
        System.out.println();

        v0.setVisited(false);
        v1.setVisited(false);
        v2.setVisited(false);
        v3.setVisited(false);
        v4.setVisited(false);
        v5.setVisited(false);
        v6.setVisited(false);
        traverseRecursively(v0);
    }
}
