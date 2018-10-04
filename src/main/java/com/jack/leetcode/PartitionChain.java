package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * @Author: Jack
 * @Date: 2018/10/4 16:19
 * LeetCode 86
 * 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，
 * 使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 例：
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class PartitionChain {
    public static void main(String[] args) {
        int []arr={1,4,3,2,5,2};
        int x=3;
        new ChainCreate().print(new PartitionChain().find(new ChainCreate().create(arr),x));
    }
    private ChainCreate.Node find(ChainCreate.Node head,int x) {
        ChainCreate.Node preHead=new ChainCreate.Node(0);
        preHead.next=head;
        ChainCreate.Node pre=preHead;
        ChainCreate.Node cur=head;
        ChainCreate.Node insertPos=null;
        while (cur!=null) {
            if ((cur.data>=x)&&insertPos==null) {
                insertPos=pre;
            }
            if (cur.data<x&&insertPos!=null) {
                pre.next=pre.next.next;
                cur.next=insertPos.next;
                insertPos.next=cur;
                insertPos=insertPos.next;
                cur=pre.next;
                continue;
            }
            pre=pre.next;
            cur=cur.next;
        }
        return preHead.next;
    }
}