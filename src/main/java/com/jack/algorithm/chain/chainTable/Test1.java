package com.jack.algorithm.chain.chainTable;

/**
 * 输入一个链表，输出该链表中倒数第K个节点
 */
public class Test1 {
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
        int k = 3;
        int [] arr = {1,2,3,4,5};
        Node head = createNode(arr);
        System.out.println(FindKthToTail(head, k).val);
    }
    public static Node createNode(int [] arr) {
        for (int i=0;i<arr.length;i++) {
            add(i+1);
        }
        return head;
    }
    public static void add(int n) {
        if (head == null) {
            head = new Node(n);
            current = head;
        } else {
            current.next = new Node(n);
            current = current.next;
        }
    }
    public static Node FindKthToTail(Node head,int k) {
        Node pointer1 = head;
        Node pointer2 = head;
        int a = k;
        int count = 0;
        while (pointer1 != null) {
            pointer1 = pointer1.next;
            count++;
            if (k<1) {
                pointer2 = pointer2.next;
            }
            k--;
        }
        if (count < a) {
            return null;
        }
        return pointer2;
    }
}