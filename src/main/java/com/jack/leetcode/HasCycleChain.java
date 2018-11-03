package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * @Author: Jack
 * @Date: 2018/9/11 16:32
 * LeetCode 141
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 */
public class HasCycleChain {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ChainCreate chainCreate = new ChainCreate();
        ChainCreate.Node node = chainCreate.create(arr);
        System.out.println(hasCycle(node));
    }
    public static boolean hasCycle(ChainCreate.Node head) {
        ChainCreate.Node fast = head;
        ChainCreate.Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}