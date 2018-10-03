package com.jack.algorithm.概览.链表.chainTable;

/**
 * 给定两个有序链表的头指针，打印两个有序链表的公共部分
 */
public class Test5 {
    private static class Node {
        int val;
        Node next = null;
        Node(int val) {
            this.val = val;
        }
    }
    public static Node head1;
    public static Node current1;
    public static Node head2;
    public static Node current2;
    public static void main(String[] args) {
        int [] arr1 = {1,2,3,4,5};
        int [] arr2 = {4,5,6,7,8};
        for (int i=0;i<arr1.length;i++) {
            addNode1(arr1[i]);
        }
        for (int i=0;i<arr1.length;i++) {
            addNode2(arr2[i]);
        }
        printNode(head1,head2);
    }
    public static void addNode1(int n) {
        if (head1 == null) {
            head1 = new Node(n);
            current1 = head1;
        } else {
            current1.next = new Node(n);
            current1 = current1.next;
        }
    }
    public static void addNode2(int n) {
        if (head2 == null) {
            head2 = new Node(n);
            current2 = head2;
        } else {
            current2.next = new Node(n);
            current2 = current2.next;
        }
    }
    public static void printNode(Node head1,Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head1 = head1.next;
            } else if (head2.val < head1.val){
                head2 = head2.next;
            } else {
                System.out.println(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}