package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * Created by Jack on 8/13/2018 10:29 PM
 * LeetCode 147
 * 对链表进行插入排序。
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，
 * 找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 */
public class ChainInsertSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 4};
        ChainCreate chainCreate = new ChainCreate();
        ChainCreate.Node node = chainCreate.create(arr);
        node = insertSortChain(node);
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    private static ChainCreate.Node insertSortChain(ChainCreate.Node head) {
        ChainCreate.Node sortedHead = new ChainCreate.Node(-1);
        while (head != null) {
            ChainCreate.Node temp = head.next;
            ChainCreate.Node current = sortedHead;
            while (current.next != null && current.next.data < head.data)
                current = current.next;
            head.next = current.next;
            current.next = head;
            head = temp;
        }
        return sortedHead.next;
    }
}
