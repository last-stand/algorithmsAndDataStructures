package graph.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Vertex {
    private String name;
    private List<Vertex> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;
    Map<Vertex, Integer> adjacentNodes = new HashMap<>();

    public Vertex(String name) {
        this.name = name;
    }

    public void addDestination(Vertex destination, int distance) {
        adjacentNodes.put(destination, distance);
        destination.adjacentNodes.put(this, distance);
    }

    public String getName() {
        return name;
    }

    public List<Vertex> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Vertex> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<Vertex, Integer> getAdjacentNodes() {
        return this.adjacentNodes;
    }

    public void setAdjacentNodes(Map<Vertex, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public String toString() {
        return this.name + "->" + this.distance;
    }
}
