package com.jack.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Jack
 * @Date: 2018/9/7 13:34
 * LeetCode 146
 * 运用你所掌握的数据结构，设计和实现一个LRU(最近最少使用) 缓存机制。
 * 它应该支持以下操作：获取数据get和写入数据put。
 * 获取数据get(key)-如果密钥(key)存在于缓存中，则获取密钥的值（总是正数），否则返回-1。
 * 写入数据put(key, value)-如果密钥不存在，则写入其数据值。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，
 * 从而为新的数据值留出空间。
 */
public class LRUCache0 {
    private Map<Integer,CacheNode> map;
    private int capacity;
    private CacheNode head=new CacheNode(-1,-1);
    private CacheNode tail=new CacheNode(-1,-1);
    private class CacheNode {
        int key,value;
        CacheNode pre,next;
        CacheNode(int key,int value) {
            this.key=key;
            this.value=value;
            this.pre=null;
            this.next=null;
        }
    }
    public LRUCache0(int capacity) {
        this.map=new HashMap<>();
        this.capacity=capacity;
    }
    private void moveToTail(CacheNode target,boolean isNew) {
        if (target!=tail.next) {
            if (!isNew) {
                target.pre.next=target.next;
                target.next.pre=target.pre;
            }
            tail.next.next=target;
            target.pre=tail.next;
            tail.next=target;
        }
    }
    public int get(int key) {
        if (map.containsKey(key)) {
            CacheNode target=map.get(key);
            moveToTail(target,false);
            tail.next.next=null;
            return target.value;
        }
        return -1;
    }
    public void put(int key,int value) {
        if (map.containsKey(key)) {
            CacheNode target=map.get(key);
            target.value=value;
            map.put(key,target);
            moveToTail(target,false);
        } else if (map.size()<capacity){
            CacheNode node=new CacheNode(key, value);
            map.put(key,node);
            if (head.next==null) {
                head.next=node;
                node.pre=head;
                tail.next=node;
            } else {
                moveToTail(node,true);
            }
        } else {
            CacheNode node=new CacheNode(key,value);
            map.remove(head.next.key);
            map.put(key,node);
            if (head.next==tail.next) {
                head.next=node;
                tail.next=node;
            } else {
                head.next.next.pre=head;
                head.next=head.next.next;
                moveToTail(node,true);
            }
        }
    }
    public static void main(String[] args) {

    }
}