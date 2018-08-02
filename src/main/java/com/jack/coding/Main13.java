package com.jack.coding;

/**
 * Created by Jack on 7/30/2018 9:57 PM
 */
public class Main13 {
    private static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
    private static Node head1;
    private static Node current1;
    private static Node head2;
    private static Node current2;
    public static void main(String[] args) {
        int [] a1 = {1,2,3,4,5};
        int [] a2 = {3,4,5,6,7};
        for (int i=0;i<a1.length;i++) {
            createNode1(a1[i]);
        }
        for (int i=0;i<a2.length;i++) {
            createNode2(a2[i]);
        }
        Node node4 = merge(head1,head2);
        while (node4 != null) {
            System.out.print(node4.val + " ");
            node4 = node4.next;
        }
    }
    public static Node merge(Node node1,Node node2) {
        Node node3;
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        if (node1.val < node2.val) {
            node3 = node1;
            node3.next = merge(node1.next,node2);
        } else {
            node3 = node2;
            node3.next = merge(node1,node2.next);
        }
        return node3;
    }
    public static void createNode1(int n) {
        if (head1 == null) {
            head1 = new Node(n);
            current1 = head1;
        } else {
            current1.next = new Node(n);
            current1 = current1.next;
        }
    }
    public static void createNode2(int n) {
        if (head2 == null) {
            head2 = new Node(n);
            current2 = head2;
        } else {
            current2.next = new Node(n);
            current2 = current2.next;
        }
    }
}
