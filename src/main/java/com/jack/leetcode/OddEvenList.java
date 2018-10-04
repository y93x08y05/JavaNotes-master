package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * @Author: Jack
 * @Date: 2018/10/4 12:51
 * LeetCode 328
 * 给定一个单链表，把所有的奇数节点和偶数节点排在一起，
 * 这里的奇数节点和偶数节点，指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 例1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 例2:
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 */
public class OddEvenList {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        ChainCreate.Node node=new ChainCreate().create(arr);
        System.out.println(new OddEvenList().find(node));
    }
    private ChainCreate.Node find(ChainCreate.Node head) {
        if (head==null)
            return head;
        ChainCreate.Node oddHead=head,evenHead=head.next;
        ChainCreate.Node prevOdd=oddHead,prevEven=evenHead;
        while (prevOdd.next!=null&&prevEven.next!=null) {
            prevOdd.next=prevEven.next;
            prevOdd=prevOdd.next;
            prevEven.next=prevOdd.next;
            prevEven=prevEven.next;
        }
        prevOdd.next=evenHead;
        new ChainCreate().print(evenHead);
        return oddHead;
    }
}