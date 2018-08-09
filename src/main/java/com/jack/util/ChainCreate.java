package com.jack.util;

/**
 * 创建一个单链表
 */
public class ChainCreate {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public  Node head;
    public  Node current;
    public Node create(int [] arr) {
        for (int i=0;i<arr.length;i++) {
            add(arr[i]);
        }
        return head;
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
