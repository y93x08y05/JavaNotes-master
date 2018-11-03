package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * @Author: Jack
 * @Date: 2018/10/4 10:18
 * LeetCode 160
 * 相交链表
 * 编写一个程序找出两个单链表相交的起始节点。
 * A1----a1-a2-c1-c2-c3
 * B1----b1-b2-b3-c1-c2-c3
 * 在节点c1开始相交
 */
public class IntersectionNode {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 8, 3, 4, 5};
        ChainCreate.Node head1 = new ChainCreate().create(arr1);
        ChainCreate.Node head2 = new ChainCreate().create(arr2);
        System.out.println(new IntersectionNode().find(head1, head2));
    }
    private ChainCreate.Node find(ChainCreate.Node head1, ChainCreate.Node head2) {
        if (head1 == null || head2 == null)
            return null;
        int head1Length = 0;
        int head2Length = 0;
        ChainCreate.Node temp1 = head1, temp2 = head2;
        while (temp1 != null) {
            temp1 = temp1.next;
            head1Length++;
        }
        while (temp2 != null) {
            temp2 = temp2.next;
            head2Length++;
        }
        if (head2Length > head1Length) {
            temp1 = head1;
            head1 = head2;
            head2 = temp1;
            int temp = head1Length;
            head1Length = head2Length;
            head2Length = temp;
        }
        int length = head1Length - head2Length;
        while (length-- > 0)
            head1 = head1.next;
        while (head1 != null) {
            if (head1 == head2)
                return head1;
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }
}