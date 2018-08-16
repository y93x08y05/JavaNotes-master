package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * Created by Jack on 8/16/2018 11:10 PM
 * LeetCode 2
 * add chain element and return a new chain
 */
public class ChainElementAdd {
    public static void main(String[] args) {
        int [] arr1 = {1,2,3};
        int [] arr2 = {4,5,6};
        ChainCreate chainCreate1 = new ChainCreate();
        ChainCreate chainCreate2 = new ChainCreate();
        ChainCreate.Node node1 = chainCreate1.create(arr1);
        ChainCreate.Node node2 = chainCreate2.create(arr2);
        ChainCreate.Node node = addElement(node1, node2);
        while (node!=null) {
            System.out.print(node.data+" ");
            node = node.next;
        }
    }
    private static ChainCreate.Node addElement(ChainCreate.Node head1,ChainCreate.Node head2) {
        if (head1==null&&head2==null)
            return null;
        if (head1==null)
            return head2;
        if (head2==null)
            return head1;
        ChainCreate.Node result = new ChainCreate.Node(0);
        ChainCreate.Node temp = result;
        while (true) {
            if (head1!=null) {
                temp.data = temp.data + head1.data;
                head1 = head1.next;
            }
            if (head2!=null) {
                temp.data = temp.data + head2.data;
                head2 = head2.next;
            }
            temp.next = new ChainCreate.Node(temp.data/10);
            temp.data = temp.data%10;
            if (head1==null&&head2==null) {
                temp.next = temp.next.data==0?null:temp.next;
                break;
            }
            temp = temp.next;
        }
        return result;
    }
}
