package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * Created by Jack on 8/15/2018 9:33 PM
 * LeetCode 83
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 例1:
 * 输入: 1->1->2
 * 输出: 1->2
 * 例2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class ChainDeleteDuplicate1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 5, 6};
        ChainCreate chainCreate = new ChainCreate();
        ChainCreate.Node node = chainCreate.create(arr);
        node = deleteDuplicate(node);
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    private static ChainCreate.Node deleteDuplicate(ChainCreate.Node head) {
        if (head == null || head.next == null)
            return head;
        ChainCreate.Node pre = head;
        ChainCreate.Node current = head.next;
        while (current != null) {
            if (current.data == pre.data) {
                pre.next = current.next;
            } else {
                pre = pre.next;
            }
            current = current.next;
        }
        return head;
    }
}
