package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * @Author: Jack
 * @Date: 2018/9/11 16:38
 * LeetCode 142
 * 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 不允许修改给定的链表。
 */
public class DetectCycleChain {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ChainCreate chainCreate = new ChainCreate();
        ChainCreate.Node node = chainCreate.create(arr);
        System.out.println(detectCycle(node));
    }
    public static ChainCreate.Node detectCycle(ChainCreate.Node head) {
        ChainCreate.Node fast = head;
        ChainCreate.Node slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}