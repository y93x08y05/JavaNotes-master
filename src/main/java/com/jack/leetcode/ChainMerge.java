package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * Created by Jack on 8/8/2018 11:17 AM
 * LeetCode 21
 * 将两个有序链表合并为一个新的有序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class ChainMerge {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {2, 3, 4, 5};
        ChainCreate chainCreate1 = new ChainCreate();
        ChainCreate chainCreate2 = new ChainCreate();
        ChainCreate.Node node1 = chainCreate1.create(arr1);
        ChainCreate.Node node2 = chainCreate2.create(arr2);
        ChainCreate.Node node3 = mergeTwoList(node1, node2);
        while (node3 != null) {
            System.out.print(node3.data + " ");
            node3 = node3.next;
        }
    }
    private static ChainCreate.Node mergeTwoList(ChainCreate.Node node1, ChainCreate.Node node2) {
        ChainCreate.Node node3;
        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;
        if (node1.data < node2.data) {
            node3 = node1;
            node3.next = mergeTwoList(node1.next, node2);
        } else {
            node3 = node2;
            node3.next = mergeTwoList(node1, node2.next);
        }
        return node3;
    }
}
