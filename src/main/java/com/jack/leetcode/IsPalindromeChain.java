package com.jack.leetcode;

import com.jack.util.ChainCreate;

import java.util.Stack;

/**
 * @Author: Jack
 * @Date: 2018/9/11 18:28
 * LeetCode 234
 * 回文链表
 * 请判断一个链表是否为回文链表。
 * 例1:
 * 输入: 1->2
 * 输出: false
 * 例2:
 * 输入: 1->2->2->1
 * 输出: true
 */
public class IsPalindromeChain {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1};
        ChainCreate chainCreate = new ChainCreate();
        ChainCreate.Node node = chainCreate.create(arr);
        System.out.println(isPalindrome(node));
    }
    public static boolean isPalindrome(ChainCreate.Node head) {
        ChainCreate.Node fast = head;
        ChainCreate.Node slow = head;
        Stack<Integer> stack = new Stack<>();
        while(fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null) {
            slow = slow.next;
        }
        while(slow != null) {
            int top = stack.pop();
            if(top != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}