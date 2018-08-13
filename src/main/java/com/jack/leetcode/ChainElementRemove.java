package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * Created by Jack on 8/13/2018 4:18 PM
 * LeetCode 203
 * delete all node if node.data equals given val
 */
public class ChainElementRemove {
    public static void main(String[] args) {
        int [] arr = {1,2,6,3,4,5,6};
        int n = 6;
        ChainCreate chainCreate = new ChainCreate();
        ChainCreate.Node node = chainCreate.create(arr);
        node = removeElement(node,n);
        while (node!=null) {
            System.out.print(node.data+" ");
            node=node.next;
        }
    }
    private static ChainCreate.Node removeElement(ChainCreate.Node head,int val) {
            ChainCreate.Node root = new ChainCreate.Node(0);
            root.next = head;
            ChainCreate.Node pre = root;
            ChainCreate.Node current = head;
            while (current!=null) {
                if (current.data!=val)
                    pre = pre.next;
                else
                    pre.next=current.next;
                current=current.next;
            }
            return root.next;
    }
}
