package com.jack.util;

/**
 * Created by Jack on 8/8/2018 2:22 PM
 * Leetcode 19
 */
public class ChainNodeDelete {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        int n = 2;
        ChainCreate chainCreate = new ChainCreate();
        ChainCreate.Node node = chainCreate.create(arr);
        ChainCreate.Node node1 = deleteNode(node,n);
        while (node1 != null) {
            System.out.print(node1.data + " ");
            node1 = node1.next;
        }
    }
    private static ChainCreate.Node deleteNode(ChainCreate.Node head,int n) {
        if (head == null || n < 1)
            return null;
        ChainCreate.Node fast = head;
        ChainCreate.Node slow = head;
        int m = n + 1;
        while (fast.next != null && m > 0) {
            --m;
            fast = fast.next;
        }
        if (m > 1)
            return null;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (m == 1)
            head = head.next;
        else
            slow.next = slow.next.next;
        return head;
    }
}
