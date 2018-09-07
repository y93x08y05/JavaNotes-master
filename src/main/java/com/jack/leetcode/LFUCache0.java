package com.jack.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: Jack
 * @Date: 2018/9/7 14:02
 * LeetCode 460
 * 设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get和put。
 * get(key)-如果键存在于缓存中，则获取键的值（总是正数），否则返回-1。
 * put(key, value)-如果键不存在，请设置或插入值。
 * 当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。
 * 在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，
 * 最近最少使用的键将被去除。
 */
public class LFUCache0 {
    Node head = null;
    final int capacity;
    Map<Integer, Integer> valueMap;
    Map<Integer, Node> nodeMap;
    public LFUCache0 (int capacity) {
        this.capacity = capacity;
        valueMap = new HashMap<>(this.capacity, 1f);
        nodeMap = new HashMap<>(this.capacity, 1f);
    }
    public int get(int key) {
        if (valueMap.containsKey(key)) increase(key, valueMap.get(key));
        return valueMap.getOrDefault(key, -1);
    }
    private void increase(int key, int value) {
        Node node = nodeMap.get(key);
        node.keys.remove(key);
        if (Objects.isNull(node.next)) node.next = new Node(node, null, 1 + node.count, key);
        else if (node.next.count == node.count + 1) node.next.keys.add(key);
        else node.next = node.next.prev = new Node(node, node.next, node.count + 1, key);
        nodeMap.put(key, node.next);
        valueMap.put(key, value);
        if (node.keys.isEmpty()) remove(node);
    }
    private void remove(Node node) {
        if (head == node) head = node.next;
        else node.prev.next = node.next;
        if (Objects.nonNull(node.next)) node.next.prev = node.prev;
    }
    public void put(int key, int value) {
        if (0 == this.capacity) return;
        if (valueMap.containsKey(key)) {
            increase(key, value);
        } else {
            if (valueMap.size() == this.capacity) remove();
            valueMap.put(key, value);
            add(key);
        }
    }
    private void add(int key) {
        if (Objects.isNull(head)) head = new Node(null, null, 1, key);
        else if (head.count == 1) head.keys.add(key);
        else head = head.prev = new Node(null, head, 1, key);
        nodeMap.put(key, head);
    }
    private void remove() {
        if (Objects.isNull(head)) return;
        int oldest = head.keys.iterator().next();
        head.keys.remove(oldest);
        if (head.keys.isEmpty()) remove(head);
        nodeMap.remove(oldest);
        valueMap.remove(oldest);
    }
    class Node {
        public Node prev, next;
        public final int count;
        public LinkedHashSet<Integer> keys = new LinkedHashSet<>();
        public Node(Node prev, Node next, int count, int key) {
            this.prev = prev;
            this.next = next;
            this.count = count;
            keys.add(key);
        }
    }
    public static void main(String[] args) {

    }
}