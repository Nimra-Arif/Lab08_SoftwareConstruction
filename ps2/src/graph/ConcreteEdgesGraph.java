/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * An implementation of Graph with String-labeled vertices and weighted directed edges.
 * 
 * <p>PS2 instructions: you MUST use the provided rep.
 */
public class ConcreteEdgesGraph implements Graph<String> {
    
    private final Set<String> vertices = new HashSet<>();
    private final List<Edge> edges = new ArrayList<>();
    
    // Abstraction function:
    //   Represents a weighted directed graph with String-labeled vertices.
    //   vertices: Set containing unique vertex labels.
    //   edges: List containing directed edges between vertices, each with a weight.

    // Representation invariant:
    //   No duplicate vertices in 'vertices' set.
    //   Every Edge in 'edges' list has valid source and target vertices present in 'vertices'.

    // Safety from rep exposure:
    //   - 'vertices' and 'edges' are private final fields.
    //   - Return defensive copies in observer methods (vertices(), sources(), targets()).
    
    
    /**
     * Adds a vertex to the graph.
     *
     * @param vertex The vertex to be added.
     * @return True if the vertex is added, false if it already exists.
     */
    @Override
    public boolean add(String vertex) {
        return vertices.add(vertex);
    }
    
    /**
     * Adds or updates an edge in the graph.
     *
     * @param source The source vertex of the edge.
     * @param target The target vertex of the edge.
     * @param weight The weight of the edge.
     * @return The previous weight of the edge, 0 if it's a new edge.
     * @throws IllegalArgumentException if source or target vertices do not exist.
     */
    @Override
    public int set(String source, String target, int weight) {
        for (Edge edge : edges) {
            if (edge.source.equals(source) && edge.target.equals(target)) {
                int prevWeight = edge.weight;
                edge.weight = weight;
                return prevWeight;
            }
        }
        edges.add(new Edge(source, target, weight));
        return 0;
    }
    
    /**
     * Removes a vertex from the graph.
     *
     * @param vertex The vertex to be removed.
     * @return True if the vertex is removed, false if it doesn't exist.
     */
    @Override
    public boolean remove(String vertex) {
        return vertices.remove(vertex) && edges.removeIf(edge -> edge.source.equals(vertex) || edge.target.equals(vertex));
    }
    
    /**
     * Returns all vertices in the graph.
     *
     * @return Set of vertices in the graph.
     */
    @Override
    public Set<String> vertices() {
        return new HashSet<>(vertices);
    }
    
    /**
     * Returns sources that have an edge leading to the given target vertex.
     *
     * @param target The target vertex.
     * @return Map of source vertices with their corresponding weights leading to the target.
     */
    @Override
    public Map<String, Integer> sources(String target) {
        Map<String, Integer> sourceMap = new HashMap<>();
        for (Edge edge : edges) {
            if (edge.target.equals(target)) {
                sourceMap.put(edge.source, edge.weight);
            }
        }
        return sourceMap;
    }
    
    /**
     * Returns targets that can be reached from the given source vertex.
     *
     * @param source The source vertex.
     * @return Map of target vertices with their corresponding weights reachable from the source.
     */
    @Override
    public Map<String, Integer> targets(String source) {
        Map<String, Integer> targetMap = new HashMap<>();
        for (Edge edge : edges) {
            if (edge.source.equals(source)) {
                targetMap.put(edge.target, edge.weight);
            }
        }
        return targetMap;
    }
    
    /**
     * Provides a string representation of the graph.
     *
     * @return String representation of the graph.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Vertices: ").append(vertices).append("\n");
        str.append("Edges: ").append(edges).append("\n");
        return str.toString();
    }
    
}

/**
 * Represents an immutable edge in the graph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 */
class Edge {
    
    private final String source;
    private final String target;
    private int weight;
    
    // Abstraction function:
    //   Represents a directed edge from 'source' vertex to 'target' vertex with 'weight'.
    //
    // Representation invariant:
    //   'source' and 'target' are non-null and non-empty strings.
    //   'weight' is a positive integer.
    //
    // Safety from rep exposure:
    //   All fields are private and final. No mutator methods are provided.
    
    /**
     * Constructor for Edge.
     *
     * @param source The source vertex.
     * @param target The target vertex.
     * @param weight The weight of the edge.
     */
    Edge(String source, String target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    /**
     * Validates the representation invariant.
     */
    private void checkRep() {
        assert source != null && !source.isEmpty() : "Invalid source vertex";
        assert target != null && !target.isEmpty() : "Invalid target vertex";
        assert weight > 0 : "Weight should be a positive integer";
    }

    /**
     * Retrieves the source vertex of the edge.
     *
     * @return The source vertex.
     */
    public String getSource() {
        return source;
    }

    /**
     * Retrieves the target vertex of the edge.
     *
     * @return The target vertex.
     */
    public String getTarget() {
        return target;
    }

    /**
     * Retrieves the weight of the edge.
     *
     * @return The weight.
     */
    public int getWeight() {
        return weight;
    }
      
    /**
     * Provides a string representation of the edge.
     *
     * @return String representation of the edge.
     */
    @Override
    public String toString() {
        return "(" + source + " -> " + target + ", weight: " + weight + ")";
    }
    
}
