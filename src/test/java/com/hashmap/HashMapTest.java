package com.hashmap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashMapTest {
    private MyHashMap hashMap;
    @Before
    public void setUp() {
        hashMap = new MyHashMap();
    }
    @Test
    public void testHashMap() {
        hashMap.add("key", 12);
        Node node = hashMap.get("key");
        Assert.assertEquals(12, node.getValue());
    }

    @Test
    public void testEqualKeys() {
        hashMap.add("key", 12);
        Node node = hashMap.get("key");
        Assert.assertEquals(12, node.getValue());
        hashMap.add("key", 15);
        Node node2 = hashMap.get("key");
        Assert.assertEquals(12, node2.getValue());
    }

    @Test
    public void testEqualIndexes() {
        hashMap.add("key", 12);
        Node node = hashMap.get("key");
        Assert.assertEquals(12, node.getValue());
        hashMap.add("kay", 15);
        Node node3 = hashMap.get("kay");
        Assert.assertEquals(15, node3.getValue());
    }
}
