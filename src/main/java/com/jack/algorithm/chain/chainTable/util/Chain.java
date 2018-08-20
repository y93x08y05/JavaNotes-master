package com.jack.algorithm.chain.chainTable.util;

public class Chain {
    private static class Node{
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    public static Node head;
    public static Node current;
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        for (int i=0;i<arr.length;i++) {
            add(i+1);
        }
        print(head);
    }
    public static void add(int data) {
        if (head == null) {
            head = new Node(data);
            current = head;
        } else {
            current.next = new Node(data);
            current = current.next;
        }
    }
    public static void print(Node node) {
        if (node == null) {
            return;
        }
        current = node;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}