package com.jack.leetcode;

/**
 * @Author: Jack
 * @Date: 2018/10/4 20:31
 * LeetCode 430
 * 扁平化多级双向链表
 * 有一个双向链表，除了下一个和前一个指针之外，还有一个子指针。
 * 可能指向单独的双向链表，子列表可能有一个或多个自己的子项
 * 生成多级数据结构，扁平化列表，使得所有结点出现在单级双链表中，
 * 将获得列表第一级的头部。
 * 例：
 * 输入:
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 * 输出:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 */
public class FlattenChain {
    public static void main(String[] args) {
        new FlattenChain().find(new Node(0,null,null,null));
    }
    private Node find(Node head) {
        if (head==null)
            return null;
        if (head.child==null)
            head.next= find(head.next);
        else {
            Node n= find(head.next);
            Node c=head.child;
            head.child=null;
            c= find(c);
            c.prev=head;
            head.next=c;
            while (c!=null&&c.next!=null)
                c=c.next;
            c.next=n;
            if (n!=null)
                n.prev=c;
        }
        return head;
    }
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
        public Node() {}
        public Node(int val,Node prev,Node next,Node child) {
            this.val=val;
            this.prev=prev;
            this.next=next;
            this.child=child;
        }
    }
}