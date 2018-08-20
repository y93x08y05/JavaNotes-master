package com.jack.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 遍历二叉树，从上往下打印二叉树节点，同层节点从左到右打印
 */
public class Test7 {
    class Node{
        int val = 0;
        Node left = null;
        Node right = null;
        Node(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printFromTopToBottom(Node root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node t = queue.poll();
            list.add(t.val);
            if (t.left != null) {
                queue.add(t.left);
            }
            if (t.right != null) {
                queue.add(t.right);
            }
        }
        return list;
    }
}