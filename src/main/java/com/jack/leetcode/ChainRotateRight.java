package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * Created by Jack on 8/15/2018 10:23 PM
 * LeetCode 61
 * give chain and k then rotate chain
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
