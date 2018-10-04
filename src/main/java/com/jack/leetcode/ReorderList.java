package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * @Author: Jack
 * @Date: 2018/10/4 14:55
 * LeetCode 143
 * 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 例1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 例2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class ReorderList {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5};
        new ReorderList().find(new ChainCreate().create(arr));
    }
    public void find(ChainCreate.Node head) {
        if (head==null||head.next==null||head.next.next==null)
            return;
        ChainCreate.Node slow=head;
        ChainCreate.Node fast=head;
        while (fast.next!=null&&fast.next.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        ChainCreate.Node second=slow.next;
        slow.next=null;
        second=reverse(second);
        ChainCreate.Node first=head;
        while (second!=null) {
            ChainCreate.Node next=first.next;
            first.next=second;
            second=second.next;
            first=first.next;
            first.next=next;
            first=first.next;
        }
    }
    private ChainCreate.Node reverse(ChainCreate.Node head) {
        ChainCreate.Node prev=null;
        ChainCreate.Node next;
        while (head!=null) {
            next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}