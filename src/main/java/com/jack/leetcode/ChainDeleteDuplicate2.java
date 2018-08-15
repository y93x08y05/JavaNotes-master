package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * Created by Jack on 8/15/2018 10:00 PM
 * LeetCode 82
 * delete all duplicate element only keep no duplicate element
 */
public class ChainDeleteDuplicate2 {
    public static void main(String[] args) {
        int [] arr = {1,2,3,3,4,5,6};
        ChainCreate chainCreate = new ChainCreate();
        ChainCreate.Node node = chainCreate.create(arr);
        node = deleteDuplicate(node);
        while (node!=null) {
            System.out.print(node.data+" ");
            node=node.next;
        }
    }
    private static ChainCreate.Node deleteDuplicate(ChainCreate.Node head) {
        if (head==null||head.next==null)
            return head;
        ChainCreate.Node root = new ChainCreate.Node(-1);
        ChainCreate.Node result = root;
        ChainCreate.Node pre = head;
        ChainCreate.Node current = head;
        while (current!=null&&current.next!=null) {
            while (current.next!=null&&current.next.data==pre.data)
                current=current.next;
            if (current==pre) {
                result.next = pre;
                result=result.next;
            }
            pre=current.next;
            current=current.next;
        }
        result.next=current;
        return root.next;
    }
}
