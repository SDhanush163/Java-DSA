package com.dhanush.graph;

import java.util.*;

public class Graph {
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if (fromNode == null) {
            String errorMessage = "Could not find a node for " + from;
            throw new IllegalArgumentException(errorMessage);
        }

        if (toNode == null) {
            String errorMessage = "Could not find a node for " + to;
            throw new IllegalArgumentException(errorMessage);
        }

        adjacencyList.get(fromNode).add(toNode);
    }

    public boolean removeNode(String label) {
        Node node = nodes.get(label);
        if (node == null)
            return false;

        for (Node n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);

        adjacencyList.remove(node);
        nodes.remove(label);
        return true;
    }

    public boolean removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            return false;

        adjacencyList.get(fromNode).remove(toNode);
        return true;
    }

    public List<Node> traverseDepthFirst(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return null;
        List<Node> list = new ArrayList<>();
        traverseDepthFirst(node, new HashSet<>(), list);
        return list;
    }

    private void traverseDepthFirst(Node root, Set<Node> visited, List<Node> list) {
        list.add(root);
        visited.add(root);

        for (Node node : adjacencyList.get(root))
            if (!visited.contains(node))
                traverseDepthFirst(node, visited, list);
    }

    public List<String> toArrayString() {
        List<String> connectedNodes = new ArrayList<>();
        for (Node source : adjacencyList.keySet()) {
            List<Node> target = adjacencyList.get(source);
            connectedNodes.add(source + "=>" + target);
        }
        return connectedNodes;
    }

    public List<Node> traverseBreadthFirst(String root) {

        Node node = nodes.get(root);
        if (node == null)
            return null;

        List<Node> list = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (visited.contains(current))
                continue;

            list.add(current);
            visited.add(current);

            for (Node neighbor : adjacencyList.get(current))
                if (!visited.contains(neighbor))
                    queue.add(neighbor);
        }

        return list;
    }

    @Override
    public String toString() {
        List<String> connectedNodes = toArrayString();
        return connectedNodes.toString();
    }
}
