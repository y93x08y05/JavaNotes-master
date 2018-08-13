package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * Created by Jack on 8/13/2018 3:37 PM
 * LeetCode 237
 * delete node of chain and it not have preNode only have postNode
 */
public class ChainNodeDelete2 {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        ChainCreate chainCreate = new ChainCreate();
        ChainCreate.Node node = chainCreate.create(arr);
        deleteNode(node.next.next);
    }
    private static void deleteNode(ChainCreate.Node node) {
        if (node==null||node.next==null)
            return;
        node.data=node.next.data;
        node.next=node.next.next;
        return;
    }
}
