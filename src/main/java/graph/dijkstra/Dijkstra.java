package graph.dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/*
* https://www.baeldung.com/java-dijkstra
* https://www.youtube.com/watch?v=bZkzH5x0SKU
*/
public class Dijkstra {
    public static Graph calculateShortestPathFromSource(Graph graph, Vertex source) {
        Set<Vertex> settledNodes = new HashSet<>();
        Set<Vertex> unsettledNodes = new HashSet<>();
        source.setDistance(0);
        unsettledNodes.add(source);
        while (unsettledNodes.size() != 0) {
            Vertex currrentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currrentNode);
            for (Map.Entry<Vertex, Integer> adjacencyPair: currrentNode.getAdjacentNodes().entrySet()){
                Vertex adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currrentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currrentNode);
        }
        return graph;
    }

    private static Vertex getLowestDistanceNode(Set<Vertex> unsettledNodes) {
        Vertex lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Vertex node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if(nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(Vertex evaluationNode, Integer edgeWeigh, Vertex sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Vertex> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}
