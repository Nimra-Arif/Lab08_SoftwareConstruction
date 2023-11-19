/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Test;

/**
 * Tests for instance methods of Graph.
 * 
 * <p>PS2 instructions: you MUST NOT add constructors, fields, or non-@Test
 * methods to this class, or change the spec of {@link #emptyInstance()}.
 * Your tests MUST only obtain Graph instances by calling emptyInstance().
 * Your tests MUST NOT refer to specific concrete implementations.
 */
public abstract class GraphInstanceTest {
    
    // Testing strategy
    //   For each method in the Graph interface, we'll test various aspects:
    //   - Adding and removing vertices
    //   - Adding and removing edges
    //   - Setting and retrieving weights
    //   - Modifying the graph (combining different operations)
    
    /**
     * Overridden by implementation-specific test classes.
     * 
     * @return a new empty graph of the particular implementation being tested
     */
    public abstract Graph<String> emptyInstance();
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testInitialVerticesEmpty() {
        // Testing strategy: Empty graph should have no vertices initially
        // Description: Asserts that an empty graph has no vertices using the vertices() method
        assertEquals("expected new graph to have no vertices",
                Collections.emptySet(), emptyInstance().vertices());
    }
    
    // Test adding vertices to the graph
    @Test
    public void testAddVertices() {
        // Testing strategy: Add vertices to an empty graph
        // Description: Adds vertices to an empty graph and verifies their presence
        Graph<String> graph = emptyInstance();
        graph.add("A");
        graph.add("B");
        assertTrue(graph.vertices().contains("A"));
        assertTrue(graph.vertices().contains("B"));
        assertEquals(2, graph.vertices().size());
    }
    
    // Test removing vertices from the graph
    @Test
    public void testRemoveVertices() {
        // Testing strategy: Remove vertices from a graph
        // Description: Adds vertices, removes one, and checks if the removed vertex is absent
        Graph<String> graph = emptyInstance();
        graph.add("A");
        graph.add("B");
        graph.remove("A");
        assertFalse(graph.vertices().contains("A"));
        assertTrue(graph.vertices().contains("B"));
        assertEquals(1, graph.vertices().size());
    }
    
    // Test existence of vertices in the graph
    @Test
    public void testVerticesExistence() {
        // Testing strategy: Verify if vertices exist in the graph
        // Description: Adds vertices to a graph and checks for their existence
        Graph<String> graph = emptyInstance();
        graph.add("A");
        graph.add("B");
        assertTrue(graph.hasVertex("A"));
        assertTrue(graph.hasVertex("B"));
        assertFalse(graph.hasVertex("C"));
    }
    
    // Test adding edges to the graph
    @Test
    public void testAddEdges() {
        // Testing strategy: Add edges between vertices in the graph
        // Description: Adds vertices and establishes an edge between them with a specific weight
        Graph<String> graph = emptyInstance();
        graph.add("A");
        graph.add("B");
        graph.set("A", "B", 5);
        assertTrue(graph.vertices().contains("A"));
        assertTrue(graph.vertices().contains("B"));
        assertTrue(graph.hasEdge("A", "B"));
        assertEquals(5, graph.getWeight("A", "B"));
    }
    
    // Test removing edges from the graph
    @Test
    public void testRemoveEdges() {
        // Testing strategy: Remove edges between vertices
        // Description: Adds vertices, establishes an edge, removes it, and checks if the edge is absent
        Graph<String> graph = emptyInstance();
        graph.add("A");
        graph.add("B");
        graph.set("A", "B", 5);
        graph.remove("A", "B");
        assertFalse(graph.hasEdge("A", "B"));
    }
    
    // Test existence of edges in the graph
    @Test
    public void testEdgesExistence() {
        // Testing strategy: Check if edges exist between specific vertices
        // Description: Adds vertices and checks for the existence of edges between them
        Graph<String> graph = emptyInstance();
        graph.add("A");
        graph.add("B");
        assertFalse(graph.hasEdge("A", "B"));
    }
    
    // Test setting and getting weights for edges
    @Test
    public void testSetAndGetWeights() {
        // Testing strategy: Set and retrieve weights for edges
        // Description: Adds vertices, sets weights for edges, and retrieves those weights
        Graph<String> graph = emptyInstance();
        graph.add("A");
        graph.add("B");
        graph.set("A", "B", 5);
        assertEquals(5, graph.getWeight("A", "B"));
        
        // Test updating weight
        graph.set("A", "B", 10);
        assertEquals(10, graph.getWeight("A", "B"));
    }
    
    // Test various graph modifications
    @Test
    public void testGraphModification() {
        // Testing strategy: Perform various modifications to the graph
        // Description: Adds vertices, establishes edges, removes vertices and edges
        // Verifies the graph's integrity after these operations
        Graph<String> graph = emptyInstance();
        graph.add("A");
        graph.add("B");
        graph.add("C");
        graph.set("A", "B", 5);
        graph.set("B", "C", 3);
        graph.remove("A");
        assertFalse(graph.hasVertex("A"));
        assertTrue(graph.hasVertex("B"));
        assertTrue(graph.hasVertex("C"));
        assertFalse(graph.hasEdge("A", "B"));
        assertTrue(graph.hasEdge("B", "C"));
    }
}
