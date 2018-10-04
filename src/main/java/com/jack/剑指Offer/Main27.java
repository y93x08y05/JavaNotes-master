package com.jack.剑指Offer;

/**
 * @Author: Jack
 * @Date: 2018/9/14 21:58
 * 给定一个链表，若其中包含环，请找出该链表的环的
 * 入口节点，否则，输出null。
 */
public class Main27 {
    static class ListNode {
        int val;
        ListNode next=null;
        ListNode(int val) {
            this.val=val;
        }
    }
    public static ListNode entryNodeOfLoop(ListNode pHead) {
        ListNode fast=pHead;
        ListNode slow=pHead;
        while (fast!=null&&fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
            if (slow==fast) {
                fast=pHead;
                while (slow!=fast) {
                    slow=slow.next;
                    fast=fast.next;
                }
                if (slow==fast)
                    return slow;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        entryNodeOfLoop(listNode);
    }
}