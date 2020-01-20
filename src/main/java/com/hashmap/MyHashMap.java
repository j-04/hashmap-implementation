package com.hashmap;

public class MyHashMap {
    private static final int MAP_SIZE = 16;
    private Node[] nodes;

    public MyHashMap() {
        nodes = new Node[MAP_SIZE];
    }

    public void add(String key, Integer value) {
        var node = new Node(key, value);
        int hash = node.hashCode();
        int index = hash & (nodes.length - 1);
        if (nodes[index] == null) {
            nodes[index] = node;
            return;
        }
        Node parentNode = nodes[index];
        while (parentNode.getNextNode() != null) {
            if (parentNode.hashCode() == hash) {
                parentNode.setKey(node.getKey());
                parentNode.setValue(node.getValue());
                break;
            }
            if (parentNode.getNextNode() == null) {
                parentNode.setNextNode(node);
            } else
                parentNode = parentNode.getNextNode();
        }
    }

    public Node get(String key) {
        int hash = getHashOfNode(key);
        int index = hash & (nodes.length - 1);
        var node = nodes[index];
        if (node != null) {
            while (node != null) {
                if (node.hashCode() == hash)
                    return node;
                else
                    node = node.getNextNode();
            }
        }
        return null;
    }

    private int getHashOfNode(String key) {
        int prime = key.length();
        int a = 0;
        char[] chars = key.toCharArray();
        for (char c: chars) {
            a = a + prime * c;
        }
        return a;
    }
}
