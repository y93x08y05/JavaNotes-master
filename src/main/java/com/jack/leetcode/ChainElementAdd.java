package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * Created by Jack on 8/16/2018 11:10 PM
 * LeetCode 2
 * 给定两个非空链表来表示两个非负整数。
 * 位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
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
