package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * Created by Jack on 8/13/2018 3:27 PM
 * LeetCode 876
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * 例1：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 例2：
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 */
public class MiddleNodeOfChain {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        ChainCreate chainCreate1 = new ChainCreate();
        ChainCreate.Node node1 = chainCreate1.create(arr);
        node1 = findMiddleNode(node1);
        while (node1 != null) {
            System.out.print(node1.data + " ");
            node1 = node1.next;
        }
    }
    private static ChainCreate.Node findMiddleNode(ChainCreate.Node head) {
        ChainCreate.Node fast = head;
        ChainCreate.Node slow = head;
        while (fast!=null&&fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
