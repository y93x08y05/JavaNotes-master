package com.jack.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Jack
 * @Date: 2018/9/7 13:12
 */
public class LRUCache1 {
    int capacity;
    int count;
    Node head;
    Node tail;
    Map<Integer,Node> map;
    public LRUCache1(int capacity) {
        this.capacity = capacity;
        this.count = 2;
        this.head = new Node(-1, -1, null, null);
        this.tail = new Node(-2, -2, this.head, null);
        this.head.next = this.tail;
        map = new HashMap<>();
        map.put(this.head.key, this.head);
        map.put(this.tail.key, this.tail);
    }
    public int get(int key) {
        int value = -1;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            detachNode(node);
            insertToHead(node);
        }
        return value;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            detachNode(node);
            insertToHead(node);
        } else {
            Node node = new Node(key, value, null, this.head);
            this.head.pre = node;
            this.head = node;
            map.put(key, node);
            this.count++;
            if (this.count > capacity)
                removeNode();
        }
    }
    public void insertToHead(Node node) {
        this.head.pre = node;
        node.next = this.head;
        node.pre = null;
        this.head = node;
    }
    public void detachNode(Node node) {
        node.pre.next = node.next;
        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            this.tail = node.pre;
        }
    }
    public void removeNode() {
        int tailKey = this.tail.key;
        this.tail = this.tail.pre;
        this.tail.next = null;
        map.remove(tailKey);
        this.count--;
    }
    public void printCache() {
        System.out.println("\nPRINT CACHE ------ ");
        System.out.println("count："+count);
        System.out.println("From head：");
        Node node = this.head;
        while (node != null) {
            System.out.println("key："+node.key+" value："+node.value);
            node = node.next;
        }
        System.out.println("From tail：");
        node = this.tail;
        while (node != null) {
            System.out.println("key：" + node.key + " value：" + node.value);
            node = node.pre;
        }
    }
    public static void main(String[] args) {
        LRUCache1 lruCache1 = new LRUCache1(3);
        lruCache1.printCache();
        lruCache1.put(1, 1);
        lruCache1.put(2, 2);
        lruCache1.put(3, 3);
        lruCache1.printCache();

        lruCache1.get(2);
        lruCache1.printCache();

        lruCache1.put(4, 4);
        lruCache1.printCache();

        lruCache1.get(1);
        lruCache1.printCache();

        lruCache1.put(3, 33);
        lruCache1.printCache();
    }
    class Node {
        int key;
        int value;
        Node next;
        Node pre;
        public Node(int key, int value, Node pre, Node next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }
}