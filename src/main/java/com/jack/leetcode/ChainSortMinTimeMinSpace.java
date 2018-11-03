package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * Created by Jack on 8/13/2018 10:38 PM
 * LeetCode 148
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 例1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 例2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class ChainSortMinTimeMinSpace {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 4};
        ChainCreate chainCreate = new ChainCreate();
        ChainCreate.Node node = chainCreate.create(arr);
        node = sortChain(node);
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    private static ChainCreate.Node sortChain(ChainCreate.Node head) {
        if (head == null || head.next == null)
            return head;
        ChainCreate.Node head1 = head;
        ChainCreate.Node head2 = getMiddle(head);
        head1 = sortChain(head1);
        head2 = sortChain(head2);
        return mergeChain(head1, head2);
    }
    private static ChainCreate.Node mergeChain(ChainCreate.Node head1, ChainCreate.Node head2) {
        ChainCreate.Node newHead = new ChainCreate.Node(-1);
        ChainCreate.Node newTail = newHead;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                newTail.next = head1;
                head1 = head1.next;
            } else {
                newTail.next = head2;
                head2 = head2.next;
            }
            newTail = newTail.next;
            newTail.next = null;
        }
        if (head1 != null) {
            newTail.next = head1;
        }
        if (head2 != null) {
            newTail.next = head2;
        }
        return newHead.next;
    }
    private static ChainCreate.Node getMiddle(ChainCreate.Node node) {
        ChainCreate.Node fast = node.next;
        ChainCreate.Node slow = node.next;
        ChainCreate.Node pre = node;
        while (true) {
            if (fast != null) {
                fast = fast.next;
            } else
                break;
            if (fast != null) {
                fast = fast.next;
            } else
                break;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        return slow;
    }
}
