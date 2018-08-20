package com.jack.algorithm.chain.chainTable;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素
 */
public class Test3 {
    private static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
    public static Node head;
    public static Node current;
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        for (int i=0;i<arr.length;i++) {
            addNode(arr[i]);
        }
        Node node = reverseList(head);
        printNode(node);
    }
    public static void addNode(int n){
        if (head == null) {
            head = new Node(n);
            current = head;
        } else {
            current.next = new Node(n);
            current = current.next;
        }
    }
    public static void printNode(Node node) {
        if (node == null) {
            return;
        }
        current = node;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
    public static Node reverseList(Node head) {
        if (head == null) {
            return null;
        }
        Node pre = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}