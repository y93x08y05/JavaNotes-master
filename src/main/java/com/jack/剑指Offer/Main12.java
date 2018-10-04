package com.jack.剑指Offer;

/**
 * Created by Jack on 7/30/2018 9:39 PM
 * 反转链表并且输出节点的值
 */
public class Main12 {
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
        for (int i=0;i<a.length;i++) {
            createNode(a[i]);
        }
        Node node = reverseChain(head);
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
    private static Node reverseChain(Node node) {
        if (node == null)
            return null;
        Node pre = null;
        Node next;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
