package com.jack.algorithm.概览.链表.chainTable;

public class Test9 {
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
        System.out.println(hasCycle(head));
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
    public static boolean hasCycle(Node node) {
        Node slow,fast;
        slow = fast = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}