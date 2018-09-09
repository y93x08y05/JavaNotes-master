package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * Created by Jack on 8/13/2018 3:37 PM
 * LeetCode 237
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 *     4 -> 5 -> 1 -> 9
 * 例1:
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 例2:
 * 输入: head = [4,5,1,9], node = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
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
