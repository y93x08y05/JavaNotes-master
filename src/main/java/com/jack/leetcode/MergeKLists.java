package com.jack.leetcode;

import com.jack.util.ChainCreate;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: Jack
 * @Date: 2018/10/4 15:39
 * LeetCode 23
 * 合并K个排序链表
 * 返回合并后的排序链表，分析和描述算法的复杂度
 * 例
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {
    public static void main(String[] args) {
        int []arr1={1,4,5};
        int []arr2={1,3,4};
        int []arr3={2,6};
        int k=3;
        ChainCreate.Node []list=new ChainCreate.Node[k];
        list[0]=new ChainCreate().create(arr1);
        list[1]=new ChainCreate().create(arr2);
        list[2]=new ChainCreate().create(arr3);
        new ChainCreate().print(new MergeKLists().find0(list));
        new ChainCreate().print(new MergeKLists().find1(list));
    }
    private ChainCreate.Node find0(ChainCreate.Node []lists) {
        if (lists.length==0||lists==null)
            return null;
        PriorityQueue<ChainCreate.Node> min=new PriorityQueue<>(11, Comparator.comparingInt(o -> o.data));
        for (ChainCreate.Node node:lists)
            if (node!=null)
                min.offer(node);
        ChainCreate.Node head=new ChainCreate.Node(0);
        ChainCreate.Node current=head;
        while (!min.isEmpty()) {
            ChainCreate.Node temp=min.poll();
            current.next=temp;
            current=current.next;
            if (temp.next!=null)
                min.offer(temp.next);
        }
        current.next=null;
        return head.next;
    }
    private ChainCreate.Node find1(ChainCreate.Node []list) {
        if (list==null||list.length==0)
            return null;
        return sort(list,0,list.length-1);
    }
    private ChainCreate.Node sort(ChainCreate.Node []list, int low, int high) {
        if (low<high) {
            int mid=(low+high)/2;
            ChainCreate.Node leftList= sort(list,low,mid);
            ChainCreate.Node rightList= sort(list,mid+1,high);
            return mergeTwoLists(leftList,rightList);
        }
        return list[low];
    }
    private ChainCreate.Node mergeTwoLists(ChainCreate.Node head1, ChainCreate.Node head2) {
        ChainCreate.Node res;
        if (head1==null)
            return head2;
        if (head2==null)
            return head1;
        if (head1.data<=head2.data) {
            res=head1;
            head1.next= mergeTwoLists(head1.next,head2);
        } else {
            res=head2;
            head2.next= mergeTwoLists(head1,head2.next);
        }
        return res;
    }
}