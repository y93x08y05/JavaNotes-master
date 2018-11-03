package com.jack.leetcode;

import java.util.HashMap;

/**
 * @Author: Jack
 * @Date: 2018/10/4 19:34
 * LeetCode 138
 * 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，
 * 该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深度拷贝。
 */
public class CopyRandomList {
    public static void main(String[] args) {
        new CopyRandomList().find(new RandomListNode(2));
    }
    private RandomListNode find(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode current = head;
        while (current != null) {
            RandomListNode node = new RandomListNode(current.label);
            map.put(current, node);
            current = current.next;
        }
        current = head;
        while (current != null) {
            RandomListNode node = map.get(current);
            node.next = map.get(current.next);
            node.random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }
    static class RandomListNode {
        int label;
        RandomListNode next,random;
        RandomListNode(int x) {
            this.label = x;
        }
    }
}