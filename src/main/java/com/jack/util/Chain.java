package com.jack.util;

/**
 * 创建一个单链表
 */
public class Chain {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node head;
    public static Node current;
    public static Chain chain = new Chain();
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        for (int i=0;i<arr.length;i++) {
            chain.add(i+1);
        }
        chain.print(head);
    }
    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            current = head;
        } else {
            current.next = new Node(data);
            current = current.next;
        }
    }
    public void print(Node node) {
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
