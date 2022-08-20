package hackerRank;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Dijkstra's Shortest Path Algorithm
 * https://www.hackerrank.com/challenges/dijkstrashortreach/problem
 * https://www.youtube.com/watch?v=BuvKtCh0SKk&t=316s
 */
public class DijkstraShortestReach2 {

    private static class Node implements Comparable<Node> {
        private final String name;
        private int distance = Integer.MAX_VALUE;

        private List<Node> shortestPath = new LinkedList<>();
        private Map<Node, Integer> adjacentNodes = new HashMap<>();

        public Node(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getDistance() {
            return this.distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public List<Node> getShortestPath() {
            return this.shortestPath;
        }

        public void setShortestPath(List<Node> shortestPath) {
            this.shortestPath = shortestPath;
        }

        public void addAdjacentNode(Node node, int distance) {
            this.adjacentNodes.put(node, distance);
            node.adjacentNodes.put(this, distance);
        }

        public Map<Node, Integer> getAdjacentNodes() {
            return this.adjacentNodes;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.distance, node.getDistance());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;

            Node node = (Node) o;

            return getName() != null ? getName().equals(node.getName()) : node.getName() == null;
        }

        @Override
        public int hashCode() {
            return getName() != null ? getName().hashCode() : 0;
        }
    }

    public static void dijkstraShortestPath(Node source) {
        source.setDistance(0);
        Set<Node> settledNodes = new HashSet<>();
        Queue<Node> unsettledNodes = new PriorityQueue<>(Collections.singleton(source));
        while (!unsettledNodes.isEmpty()) {
            Node currentNode = unsettledNodes.poll();
            currentNode.getAdjacentNodes()
                    .entrySet().stream()
                    .filter(entry -> !settledNodes.contains(entry.getKey()))
                    .forEach(entry -> {
                        evaluateDistanceAndPath(entry.getKey(), entry.getValue(), currentNode);
                        unsettledNodes.add(entry.getKey());
                    });
            settledNodes.add(currentNode);
        }
    }

    private static void evaluateDistanceAndPath(Node adjacentNode, Integer distance, Node currentNode) {
        Integer newDistance = currentNode.getDistance() + distance;
        if (newDistance < adjacentNode.getDistance()) {
            adjacentNode.setDistance(newDistance);
            LinkedList<Node> shortestPath = new LinkedList<>(currentNode.getShortestPath());
            shortestPath.add(currentNode);
            adjacentNode.setShortestPath(shortestPath);
        }
    }

    private static void printPaths(List<Node> nodes) {
        nodes.forEach(node -> {
            String path = node.getShortestPath().stream()
                    .map(Node::getName)
                    .collect(Collectors.joining(" -> "));
            if (path.isEmpty()) {
                System.out.printf("%s : %s\n", node.getName(), node.getDistance());
            } else {
                System.out.printf("%s -> %s : %s\n", path, node.getName(), node.getDistance());
            }
        });
    }

    /*
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n number of nodes or vertices
     *  2. 2D_INTEGER_ARRAY edges with weight eg 1 2 10
     *  3. INTEGER s  starting position
     */
    public static void shortestReach(int n, List<List<Integer>> edges, int s) {}


    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addAdjacentNode(nodeB, 2);
        nodeA.addAdjacentNode(nodeC, 4);

        nodeB.addAdjacentNode(nodeC, 3);
        nodeB.addAdjacentNode(nodeD, 1);
        nodeB.addAdjacentNode(nodeE, 5);

        nodeC.addAdjacentNode(nodeD, 2);

        nodeD.addAdjacentNode(nodeE, 1);
        nodeD.addAdjacentNode(nodeF, 4);

        nodeE.addAdjacentNode(nodeF, 2);

        dijkstraShortestPath(nodeA);
        printPaths(Arrays.asList(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF));


        System.out.println("\n\nFrom HackerRank\n");
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");

        node1.addAdjacentNode(node2, 24);
        node1.addAdjacentNode(node4, 20);
        node3.addAdjacentNode(node1, 3);
        node4.addAdjacentNode(node3, 12);

        dijkstraShortestPath(node1);
        printPaths(Arrays.asList(node1, node2, node3, node4));
    }
}
