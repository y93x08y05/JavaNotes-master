package com.jack.algorithm.chain.chainTable;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表
 * 合成后的链表满足单调不减规则
 */
public class Test2 {
    private static class Node {
        int val;
        Node next = null;
        Node(int val) {
            this.val = val;
        }
    }
    private static Node head1;
    private static Node current1;
    private static Node head2;
    private static Node current2;
    public static void main(String[] args) {
        int [] arr1 = {1,2,3,4,5};
        int [] arr2 = {3,4,5,6,7};
        for (int i=0;i<arr1.length;i++) {
            head1 = createNode1(arr1[i]);
        }
        for (int i=0;i<arr2.length;i++) {
            head2 = createNode2(arr2[i]);
        }
         Node node = merge(head1,head2);
        printNode(node);
    }
    public static Node createNode1(int n) {
        if (head1 == null) {
            head1 = new Node(n);
            current1 = head1;
        } else {
            current1.next = new Node(n);
            current1 = current1.next;
        }
        return head1;
    }
    public static Node createNode2(int n) {
        if (head2 == null) {
            head2 = new Node(n);
            current2 = head2;
        } else {
            current2.next = new Node(n);
            current2 = current2.next;
        }
        return head2;
    }
    public static Node merge(Node head1,Node head2) {
        Node newList;
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.val < head2.val) {
            newList = head1;
            newList.next = merge(head1.next,head2);
        } else {
            newList = head2;
            newList.next = merge(head1,head2.next);
        }
        return newList;
    }
    public static void printNode(Node node) {
        Node current;
        if (node == null) {
            return;
        }
        current = node;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}