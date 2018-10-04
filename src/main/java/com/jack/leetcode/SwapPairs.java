package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * @Author: Jack
 * @Date: 2018/10/4 13:34
 * LeetCode 24
 * 两两交换链表中的节点
 * 给定一个链表，两两交换链表中的节点
 * 例：
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 算法只能使用常数的额外空间
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 */
public class SwapPairs {
    public static void main(String[] args) {
        int []arr={1,2,3,4};
        ChainCreate.Node head=new ChainCreate().create(arr);
        new ChainCreate().print(new SwapPairs().find(head));
    }
    private ChainCreate.Node find(ChainCreate.Node head) {
        if (head==null)
            return null;
        ChainCreate.Node helper=new ChainCreate.Node(0);
        helper.next=head;
        ChainCreate.Node pre=helper;
        ChainCreate.Node cur=head;
        while (cur!=null&&cur.next!=null) {
            ChainCreate.Node next=cur.next.next;
            cur.next.next=cur;
            pre.next=cur.next;
            if (next!=null&&next.next!=null)
                cur.next=next.next;
            else
                cur.next=next;
            pre=cur;
            cur=next;
        }
        return helper.next;
    }
}