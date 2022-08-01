package graph.dijkstra;

public class Main {
    public static void main(String[] args) {
        Vertex nodeA = new Vertex("A");
        Vertex nodeB = new Vertex("B");
        Vertex nodeC = new Vertex("C");
        Vertex nodeD = new Vertex("D");
        Vertex nodeE = new Vertex("E");
        Vertex nodeF = new Vertex("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);

        for (Vertex node : graph.getNodes()) {
            System.out.println(node.getName() + ": " +node.getShortestPath());
        }
    }
}
