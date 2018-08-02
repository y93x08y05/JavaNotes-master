package com.jack.coding;

/**
 * Created by Jack on 7/30/2018 9:21 PM
 */
public class Main11 {
    private static class Node{
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
    private static Node head;
    private static Node current;
    public static void main(String[] args) {
        int a [] = {1,2,3,4,5};
        int k = 3;
        for (int i=0;i<a.length;i++) {
            createChain(a[i]);
        }
        System.out.println(findKthNode(head, k));
    }
    public static void createChain(int n) {
        if (head == null) {
            head = new Node(n);
            current = head;
        } else {
            current.next = new Node(n);
            current = current.next;
        }
    }
    public static int findKthNode(Node node,int k) {
        Node pointer1 = node;
        Node pointer2 = node;
        int a = k;
        int count = 0;
        while (pointer1 != null) {
            pointer1 = pointer1.next;
            count++;
            if (k < 1) {
                pointer2 = pointer2.next;
            }
            k--;
        }
        if (count < a) {
            return 0;
        }
        return pointer2.val;
    }
}
