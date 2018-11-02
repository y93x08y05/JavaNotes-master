package com.jack.leetcode;

import com.jack.util.ChainCreate;

/**
 * @Author: Jack
 * @Date: 2018/10/4 19:47
 * LeetCode 725
 * 分隔链表，给定一个头节点为root的链表，编写一个函数
 * 将链表分隔为K个连续的部分，每部分的长度应该尽可能的相等。
 * 任意两部分的长度差距不能超过1，可能有些部分为null。
 * 这K个部分应该按照在链表中出现的顺序进行输出，并且
 * 排在前面的部分的长度应该大于或等于后面的长度。
 * 返回一个符合上述规则的链表的列表。
 * 例：
 * 输入:
 * root = [1, 2, 3], k = 5
 * 输出: [[1],[2],[3],[],[]]
 * 解释:
 * 输入输出各部分都应该是链表，而不是数组。
 * 例如, 输入的结点 root 的 val= 1, root.next.val = 2,
 * root.next.next.val = 3, 且 root.next.next.next = null。
 * 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
 * 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
 * 例：
 * 输入:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * 解释:
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过1。
 * 前面部分的长度大于等于后面部分的长度。
 */
public class SplitListToParts {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;
        ChainCreate.Node[] res = new SplitListToParts().find(new ChainCreate().create(arr), k);
        for (int i = 0; i < res.length; i++) {
            new ChainCreate().print(res[i]);
            System.out.println();
        }
    }
    private ChainCreate.Node[] find(ChainCreate.Node root, int k) {
        ChainCreate.Node[] res = new ChainCreate.Node[k];
        if (root == null || root.next == null) {
            res[0] = root;
            return res;
        }
        int len = 0;
        ChainCreate.Node head = root;
        while (head != null) {
            len++;
            head = head.next;
        }
        int average = len / k;
        int remain = 0;
        if (len > k)
            remain = len % k;
        head = root;
        ChainCreate.Node current;
        for (int i = 0; i < k; i++) {
            res[i] = head;
            current = head.next;
            for (int j = 1; j < average; j++) {
                head = head.next;
                if (head == null)
                    break;
                current = current.next;
            }
            if (remain > 0) {
                head = head.next;
                current = current.next;
                remain--;
            }
            if (head != null)
                head.next = null;
            head = current;
            if (head == null)
                break;
        }
        return res;
    }
}