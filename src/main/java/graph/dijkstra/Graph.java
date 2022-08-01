package graph.dijkstra;

import java.util.HashSet;
import java.util.Set;

public class Graph {
    private Set<Vertex> nodes = new HashSet<>();

    public void addNode(Vertex node) {
        nodes.add(node);
    }

    public Set<Vertex> getNodes() {
        return this.nodes;
    }

    public void setNodes(Set<Vertex> nodes) {
        this.nodes = nodes;
    }
}
