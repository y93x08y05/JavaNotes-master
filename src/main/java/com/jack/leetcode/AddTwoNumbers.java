package com.jack.leetcode;

import com.jack.util.ChainCreate;

import java.util.Stack;

/**
 * @Author: Jack
 * @Date: 2018/10/4 15:21
 * LeetCode 445
 * 两数相加
 * 给定两个分空链表来代表两个非负整数，数字最高位位于链表开始位置。
 * 它们每个节点只存储单个数字。将这两个数相加会返回一个新的链表。
 * 假设除了数字0之外，这两个数字都不会以零开头。
 * 例：
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] arr1 = {7, 2, 4, 3};
        int[] arr2 = {5, 6, 4};
        ChainCreate.Node head1 = new ChainCreate().create(arr1);
        ChainCreate.Node head2 = new ChainCreate().create(arr2);
        new AddTwoNumbers().find(head1, head2);
    }
    private ChainCreate.Node find(ChainCreate.Node head1, ChainCreate.Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (head1 != null) {
            s1.push(head1.data);
            head1 = head1.next;
        }
        while (head2 != null) {
            s2.push(head2.data);
            head2 = head2.next;
        }
        int sum = 0;
        ChainCreate.Node current = new ChainCreate.Node(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty())
                sum += s1.pop();
            if (!s2.isEmpty())
                sum += s2.pop();
            ChainCreate.Node head = new ChainCreate.Node(sum / 10);
            current.data = sum % 10;
            head.next = current;
            current = head;
            sum /= 10;
        }
        if (current.data == 0)
            current = current.next;
        return current;
    }
}