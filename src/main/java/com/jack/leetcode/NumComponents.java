package com.jack.leetcode;

import com.jack.util.ChainCreate;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Jack
 * @Date: 2018/10/4 20:18
 * LeetCode 817
 * 链表组件
 * 给定一个链表的头结点head
 * 同时给定列表G，该列表是上述链表中整形值的一个子集。
 * 返回列表G中组件的个数。
 * 组件的定义：链表中一段最长连续结点的值构成的集合。
 * 例1：
 * 输入:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * 输出: 2
 * 解释:
 * 链表中,0 和 1 是相连接的，且 G 中不包含 2，
 * 所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。
 * 例2：
 * 输入:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * 输出: 2
 * 解释:
 * 链表中，0 和 1 是相连接的，3 和 4 是相连接的，
 * 所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 */
public class NumComponents {
    public static void main(String[] args) {
        int []arr={0,1,2,3};
        int []G={0,1,3};
        System.out.println(new NumComponents().find(new ChainCreate().create(arr), G));
    }
    private int find(ChainCreate.Node head,int []G) {
        Set<Integer> exist = new HashSet<>();
        for (int tmp : G)
            exist.add(tmp);
        int ans = exist.contains(head.data) ? 1 : 0;
        ChainCreate.Node current = head;
        while (current.next != null) {
            if (!exist.contains(current.data) && exist.contains(current.next.data))
                ans++;
            current=current.next;
        }
        return ans;
    }
}