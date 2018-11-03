package com.jack.leetcode;

import com.jack.util.ChainCreate;

import java.util.Objects;

/**
 * Created by Jack on 8/8/2018 2:22 PM
 * Leetcode 19
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class ChainNodeDelete1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = 2;
        ChainCreate chainCreate = new ChainCreate();
        ChainCreate.Node node = chainCreate.create(arr);
        ChainCreate.Node node1 = deleteNode(node, n);
        while (node1 != null) {
            System.out.print(node1.data + " ");
            node1 = node1.next;
        }
    }
    private static ChainCreate.Node deleteNode(ChainCreate.Node head, int n) {
        ChainCreate.Node first = new ChainCreate.Node(0);
        first.next = head;
        ChainCreate.Node p1 = first;
        ChainCreate.Node p2 = first;
        int k = 0;
        while (k < n) {
            if (p2.next == null)
                return head;
            p2 = p2.next;
            k++;
        }
        while (true) {
            if (p2.next == null) {
                p1.next = Objects.requireNonNull(p1.next).next;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return first.next;
    }
}
