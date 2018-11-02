package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * @Author: Jack
 * @Date: 2018/10/4 13:58
 * LeetCode 25
 * K个一组翻转链表
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * 例：
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
        new ChainCreate().print(new ReverseKGroup().find(new ChainCreate().create(arr), k));
    }
    private ChainCreate.Node find(ChainCreate.Node head, int k) {
        if (head == null)
            return null;
        ChainCreate.Node res = new ChainCreate.Node(0);
        res.next = head;
        int count = 0;
        ChainCreate.Node pre = res;
        ChainCreate.Node cur = head;
        while (cur != null) {
            count++;
            ChainCreate.Node next = cur.next;
            if (count == k) {
                pre = find(pre, next);
                count = 0;
            }
            cur = next;
        }
        return res.next;
    }
    private ChainCreate.Node find(ChainCreate.Node pre, ChainCreate.Node end) {
        if (pre == null || pre.next == null)
            return pre;
        ChainCreate.Node head = pre.next;
        ChainCreate.Node cur = pre.next.next;
        while (cur != end) {
            ChainCreate.Node next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        head.next = cur;
        return head;
    }
}