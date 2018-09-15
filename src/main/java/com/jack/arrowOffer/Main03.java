package com.jack.arrowOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 7/30/2018 8:09 PM
 * 输出反转之后的链表的值
 */
public class Main03 {
    private static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
    public static Node head;
    public static Node current;
    public static int [] a = {1,2,3,4,5};
    public static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        for (int i=0;i<a.length;i++) {
            createChain(a[i]);
        }
        List<Integer> list1 = printValueFromTailToHead(head);
        for (int i=0;i<list1.size();i++) {
            System.out.print(list1.get(i) + " ");
        }
    }
    public static void createChain(int m) {
        if (head == null) {
            head = new Node(m);
            current = head;
        } else {
            current.next = new Node(m);
            current = current.next;
        }
    }
    public static List<Integer> printValueFromTailToHead(Node head) {
        if (head != null) {
            printValueFromTailToHead(head.next);
            list.add(head.val);
        }
        return list;
    }
}
