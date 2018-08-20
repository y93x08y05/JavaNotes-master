package com.jack.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 按照之字型打印二叉树，奇数行从左到右打印，偶数行从右到左打印
 * 如果将所有层放入ArrayList后再将偶数层reverse，数据量大时效率低
 */
public class Test8 {
    class Node{
        int val = 0;
        Node left = null;
        Node right = null;
        Node(int val) {
            this.val = val;
        }
    }
    public ArrayList<ArrayList<Integer>> print(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<Node>();
        int rows = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i=0;i<size;i++) {
                Node t = queue.poll();
                if (rows % 2 == 0) {
                    list.add(0,t.val);//元素插入指定位置头部，即倒序
                } else {
                    list.add(t.val);//元素插入尾部
                }
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            result.add(list);
            rows++;
        }
        return result;
    }
}