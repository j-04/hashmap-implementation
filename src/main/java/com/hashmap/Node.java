package com.hashmap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    private int value;
    private String key;
    private Node nextNode;

    public Node(String key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o == this)
            return true;
        return key.equals(o);
    }

    @Override
    public int hashCode() {
        int prime = key.length();
        int a = 0;
        char[] chars = key.toCharArray();
        for (char c: chars) {
            a = a + prime * c;
        }
        return a;
    }
}
