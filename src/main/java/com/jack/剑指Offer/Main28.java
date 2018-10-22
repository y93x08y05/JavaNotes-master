package com.jack.剑指Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个链表，从尾到头打印链表
 */
public class Main28 {
    private  class ListNode{
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String [] args) {
        Main28 main28 = new Main28();
        ListNode head = main28.new ListNode(0);
        main28.printListFromTailToHead(head);
    }
    public List<Integer> printListFromTailToHead(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}