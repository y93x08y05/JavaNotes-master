package com.jack.algorithm.概览.链表.chainTable;

import java.util.Stack;

/**
 * 判断一个链表是不是一个回文结构
 */
public class Test6 {
    private static class Node {
        int val;
        Node next = null;
        Node(int val) {
            this.val = val;
        }
    }
    public static Node head;
    public static Node current;

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,3,2,1};
        for (int i=0;i<arr.length;i++) {
            addNode(arr[i]);
        }
        System.out.println(isPalindrome(head));
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
    public static boolean isPalindrome(Node head) {
        Stack<Node> stack = new Stack<Node>();
        Node current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}