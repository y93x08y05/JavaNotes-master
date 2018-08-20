package com.jack.algorithm.chain.chainTable;

import java.util.ArrayList;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值
 */
public class Test4 {
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
        ArrayList<Integer> list = printNode(head);
        for (int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
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
    public static ArrayList<Integer> list = new ArrayList<Integer>();
    public static ArrayList<Integer> printNode(Node head) {
        if (head != null) {
            printNode(head.next);
            list.add(head.val);
        }
        return list;
    }
}