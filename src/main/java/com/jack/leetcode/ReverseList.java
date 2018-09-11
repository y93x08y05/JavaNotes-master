package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * @Author: Jack
 * @Date: 2018/9/11 18:02
 * LeetCode 206
 * 反转链表
 * 反转一个单链表。
 * 例：
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseList {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5};
        ChainCreate chainCreate = new ChainCreate();
        ChainCreate.Node node = chainCreate.create(arr);
        ChainCreate.Node node1=reverseList(node);
        while (node1!=null) {
            System.out.print(node1.data+" ");
            node1=node1.next;
        }
    }
    public static ChainCreate.Node reverseList(ChainCreate.Node head) {
        ChainCreate.Node pre = null;
        ChainCreate.Node next;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}