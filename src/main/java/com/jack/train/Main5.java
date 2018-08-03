package com.jack.train;

/**
 * Created by Jack on 8/2/2018 4:28 PM
 */
public class Main5 {
    private static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
    private static Node head;
    private static Node current;
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        int m = 1;
        int n = 2;
        for (int i=0;i<a.length;i++) {
            createNode(a[i]);
        }
        Node node = reverseChain(head,m,n);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
    private static void createNode(int n) {
        if (head == null) {
            head = new Node(n);
            current = head;
        } else {
            current.next = new Node(n);
            current = current.next;
        }
    }
    private static Node reverseChain(Node node,int m,int n) {
        if (m >= n)
            return node;
        Node current = node.next;
        int i;
        for (i=1;i<m-1;i++) {
            node = current;
            current = current.next;
        }
        Node pre = current;
        current = current.next;
        n--;
        Node next;
        for (;i<n;i++) {
            next = current.next;
            current.next = node.next;
            node.next = current;
            pre.next = next;
            current = next;
        }
        return node;
    }
}
