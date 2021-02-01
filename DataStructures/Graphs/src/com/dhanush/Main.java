package com.dhanush;

import com.dhanush.graph.Graph;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("John");
        graph.addNode("Bob");
        graph.addNode("Alice");
        graph.addNode("Mary");
        graph.addNode("Sam");
        graph.addNode("Genny");

        graph.addEdge("John", "Mary");
        graph.addEdge("John", "Bob");
        graph.addEdge("John", "Alice");
        graph.addEdge("John", "Genny");
        graph.addEdge("Mary", "Bob");
        graph.addEdge("Mary", "Alice");
        graph.addEdge("Alice", "Bob");
        graph.addEdge("Alice", "Sam");

        System.out.println(graph);
        System.out.println("\nTraversing depth first from 'John' : " + graph.traverseDepthFirst("John"));
        System.out.println("Traversing breadth first from 'John' : " + graph.traverseBreadthFirst("John"));

    }
}
