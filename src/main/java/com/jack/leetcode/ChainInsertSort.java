package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * Created by Jack on 8/13/2018 10:29 PM
 * LeetCode 147
 * use insert mergeSort algorithm to mergeSort chain element
 */
public class ChainInsertSort {
    public static void main(String[] args) {
        int [] arr = {1,3,5,2,4};
        ChainCreate chainCreate = new ChainCreate();
        ChainCreate.Node node = chainCreate.create(arr);
        node = insertSortChain(node);
        while (node!=null) {
            System.out.print(node.data+" ");
            node=node.next;
        }
    }
    private static ChainCreate.Node insertSortChain(ChainCreate.Node head) {
        ChainCreate.Node sortedHead = new ChainCreate.Node(-1);
        while (head!=null) {
            ChainCreate.Node temp = head.next;
            ChainCreate.Node current = sortedHead;
            while (current.next!=null&&current.next.data<head.data)
                current=current.next;
            head.next=current.next;
            current.next=head;
            head=temp;
        }
        return sortedHead.next;
    }
}
