package com.jack.leetcode;

import com.jack.util.ChainCreate;

import java.util.Stack;

/**
 * Created by Jack on 8/13/2018 2:29 PM
 * LeetCode 92
 * 反转从位置m到n的链表。请使用一趟扫描完成反转。
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class ChainReverse2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int m = 2;
        int n = 4;
        ChainCreate chainCreate1 = new ChainCreate();
        ChainCreate.Node node1 = chainCreate1.create(arr);
        node1 = reverseBetween1(node1, m, n);
        while (node1 != null) {
            System.out.print(node1.data + " ");
            node1 = node1.next;
        }
        System.out.println();
        ChainCreate chainCreate2 = new ChainCreate();
        ChainCreate.Node node2 = chainCreate2.create(arr);
        node2 = reverseBetween2(node2, m, n);
        while (node2 != null) {
            System.out.print(node2.data + " ");
            node2 = node2.next;
        }
        System.out.println();
        ChainCreate chainCreate3 = new ChainCreate();
        ChainCreate.Node node3 = chainCreate3.create(arr);
        node3 = reverseBetween3(node3, m, n);
        while (node3 != null) {
            System.out.print(node3.data + " ");
            node3 = node3.next;
        }
    }
    private static ChainCreate.Node reverseBetween1(ChainCreate.Node node, int m, int n) {
        if (node == null || node.next == null || m >= n)
            return node;
        ChainCreate.Node first = new ChainCreate.Node(0);
        first.next = node;
        node = first;
        ChainCreate.Node preNode = node;
        for (int i = 1; i < m; i++)
            preNode = preNode.next;
        ChainCreate.Node tempNode = preNode.next;
        Stack<ChainCreate.Node> stack = new Stack<>();
        int i = 0;
        while (m + i <= n) {
            stack.push(tempNode);
            tempNode = tempNode.next;
            i++;
        }
        ChainCreate.Node postNode = tempNode;
        ChainCreate.Node resultNode  = stack.pop();
        tempNode = resultNode;
        while (!stack.isEmpty()) {
            tempNode.next = stack.pop();
            tempNode = tempNode.next;
        }
        preNode.next = resultNode;
        tempNode.next = postNode;
        return first.next;
    }
    private static ChainCreate.Node reverseBetween2(ChainCreate.Node node, int m, int n) {
        if (node == null || node.next == null || m >= n)
            return node;
        ChainCreate.Node first = new ChainCreate.Node(0);
        first.next = node;
        node = first;
        ChainCreate.Node preNode = node;
        for (int i = 1; i < m; i++)
            preNode = preNode.next;
        ChainCreate.Node nodeA = preNode.next;
        ChainCreate.Node nodeB = preNode.next.next;
        ChainCreate.Node nodeResult = nodeA;
        int i = 0;
        while (m + i < n) {
            nodeA.next = nodeB.next;
            nodeB.next = nodeResult;
            nodeResult = nodeB;
            nodeB = nodeA.next;
            i++;
        }
        preNode.next = nodeResult;
        return first.next;
    }
    private static ChainCreate.Node reverseBetween3(ChainCreate.Node node, int m, int n) {
        if (node == null || node.next == null || m >= n)
            return node;
        ChainCreate.Node first = new ChainCreate.Node(0);
        first.next = node;
        node = first;
        ChainCreate.Node preNode = node;
        for (int i = 1; i < m; i++)
            preNode = preNode.next;
        ChainCreate.Node nodeA = preNode.next;
        ChainCreate.Node nodeB = preNode.next.next;
        for (int i = 0; i < n - m; i++) {
            nodeA.next = nodeB.next;
            nodeB.next = preNode.next;
            preNode.next = nodeB;
            nodeB = nodeA.next;
        }
        return first.next;
    }
}
