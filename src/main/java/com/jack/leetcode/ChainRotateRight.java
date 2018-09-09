package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * Created by Jack on 8/15/2018 10:23 PM
 * LeetCode 61
 * 给定一个链表，旋转链表，
 * 将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 例1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 例2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class ChainRotateRight {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        int k = 2;
        ChainCreate chainCreate = new ChainCreate();
        ChainCreate.Node node = chainCreate.create(arr);
        node = rotateRight(node,k);
        while (node!=null) {
            System.out.print(node.data+" ");
            node=node.next;
        }
    }
    private static ChainCreate.Node rotateRight(ChainCreate.Node head,int k) {
        if (head==null||k==0)
            return head;
        int cnt = 1;
        ChainCreate.Node p2 = head;
        while (p2.next!=null) {
            cnt++;
            p2=p2.next;
        }
        k=k%cnt;
        ChainCreate.Node pHead = head;
        ChainCreate.Node p1 = head;
        for (int i=0;i<cnt-k-1;i++) {
            p1 = p1.next;
        }
        p2.next = pHead;
        pHead = p1.next;
        p1.next = null;
        return pHead;
    }
}
