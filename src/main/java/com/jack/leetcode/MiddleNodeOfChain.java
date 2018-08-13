package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * Created by Jack on 8/13/2018 3:27 PM
 * LeetCode 876
 * find middle node from single chain
 */
public class MiddleNodeOfChain {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        ChainCreate chainCreate1 = new ChainCreate();
        ChainCreate.Node node1 = chainCreate1.create(arr);
        node1 = findMiddleNode(node1);
        while (node1 != null) {
            System.out.print(node1.data + " ");
            node1 = node1.next;
        }
    }
    private static ChainCreate.Node findMiddleNode(ChainCreate.Node head) {
        ChainCreate.Node fast = head;
        ChainCreate.Node slow = head;
        while (fast!=null&&fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
