package com.jack.leetcode;

/**
 * @Author: Jack
 * @Date: 2018/10/4 11:00
 * LeetCode 707
 * 设计链表
 * 选择单链表或者双链表，单链表中的节点应该具有两个属性：val和next。val
 * 是当前节点的值，next是指向下一个节点的指针或者引用。如果要使用双向链表
 * 则增加一个prev属性指示链表中的上一个节点。
 * （1）get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1。
 * （2）addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。
 * 插入后，新节点将成为链表的第一个节点。
 * （3）addAtTail(val)：将值为val的节点追加到链表的最后一个元素。
 * （4）addAtIndex(index,val)：在链表中的第index个节点之前添加值为val的节点。
 * 如果index等于链表的长度，则该节点将附加到链表的末尾。
 * 如果index大于链表长度，则不会插入节点。
 * （5）deleteAtIndex(index)：如果索引index有效，则删除链表中的第index个节点。
 * 例：
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 */
public class MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList=new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(1);
        System.out.println(linkedList.get(1));
    }
    class Entry {
        int val;
        Entry next;
        public Entry() {

        }
        public Entry(int n) {
            val=n;
        }
    }
    Entry head;
    int size;
    public MyLinkedList() {
        head=new Entry();
        size=0;
    }
    public int get(int index) {
        if (index>=size||index<0)
            return -1;
        Entry t=head;
        for (int i=0;i<=index;i++)
            t=t.next;
        return t.val;
    }
    public void addAtHead(int val) {
        Entry t=new Entry(val);
        if (head.next==null)
            head.next=t;
        else {
            t.next=head.next;
            head.next=t;
        }
        size++;
    }
    public void addAtTail(int val) {
        Entry t=new Entry(val);
        Entry x=head;
        while (x.next!=null)
            x=x.next;
        x.next=t;
        size++;
    }
    public void addAtIndex(int index,int val) {
        if (index>size||index<0)
            return;
        else if (index==size)
            addAtTail(val);
        else {
            Entry x=head;
            for (int i=0;i<index;i++)
                x=x.next;
            Entry t=new Entry(val);
            t.next=x.next;
            x.next=t;
            size++;
        }
    }
    public void deleteAtIndex(int index) {
        if (index>=size||index<0)
            return;
        else {
            Entry x=head;
            for (int i=0;i<index;i++)
                x=x.next;
            Entry del=x.next;
            x.next=del.next;
            del.next=null;
        }
        size--;
    }
}