package com.jack.nowcoder.spring.ArrowOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，从尾到头打印链表
 */
public class PrintList {
    private static class ListNode{
        int val;
        ListNode next;
    }
    public static void main(String [] args) {
        ListNode listNode = new ListNode();
        printListFromTailToHead(listNode);
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}