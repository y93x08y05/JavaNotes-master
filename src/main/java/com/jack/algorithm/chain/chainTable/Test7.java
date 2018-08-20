package com.jack.algorithm.chain.chainTable;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 删除一个无序单链表中重复出现的节点
 */
public class Test7 {
    private static class Node {
        int val;
        Node next = null;
        Node(int val) {
            this.val = val;
        }
    }
    public static Node head;
    public static Node current;

    public static void main(String[] args) {
        int [] arr = {1,2,5,4,1,5,3};
        for (int i=0;i<arr.length;i++) {
            addNode(arr[i]);
        }
        HashSet<Integer> temp = removeNode(head);
        printNode(temp);
    }
    public static void addNode(int n) {
        if (head == null) {
            head = new Node(n);
            current = head;
        } else {
            current.next = new Node(n);
            current = current.next;
        }
    }
    public static void printNode(HashSet<Integer> set) {
        if (set.size() == 0) {
            return;
        }
        Iterator<Integer> iterable = set.iterator();
        while (iterable.hasNext()) {
            System.out.println(iterable.next());
        }
    }
    public static HashSet<Integer> removeNode(Node node) {
        if (node == null) {
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        Node pre = node;
        Node current = node.next;
        set.add(node.val);
        while (current != null) {
            if (set.contains(current.val)) {
                pre.next = current.next;
            } else {
                set.add(current.val);
                pre = current;
            }
            current = current.next;
        }
        return set;
    }
}