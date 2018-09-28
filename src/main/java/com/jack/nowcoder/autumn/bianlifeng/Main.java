package com.jack.nowcoder.autumn.bianlifeng;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/28 10:06
 */
public class Main {
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
    public Main(int capacity) {
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
        Scanner sc=new Scanner(System.in);
        Main main =new Main(sc.nextInt());
        sc.nextLine();
        while (sc.hasNext()){
            String []str=sc.nextLine().split(" ");
            if (str.length==1){
                System.out.println(main.get(Integer.parseInt(str[0])));
            } else {
                main.put(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
            }
        }
    }
}