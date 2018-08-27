package com.jack.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 遍历二叉树，从上往下打印二叉树节点，同层节点从左到右打印
 */
public class FromTopToBottomPrintTree {
    class Node{
        int value;
        Node left = null;
        Node right = null;
        Node(int val) {
            this.value = val;
        }
    }
    public static void main(String[] args) {
        FromTopToBottomPrintTree print=new FromTopToBottomPrintTree();
        int [] arr = {1,2,3,4,5,6,7};
        Node root = print.createTree(arr,0,arr.length-1);
        print.printFromTopToBottom(root);
    }
    private Node createTree(int [] a , int left , int right) {
        if (left > right) {
            return null;
        }
        Node node = new Node(a[(left + right) / 2]);
        node.value = a[(left + right) / 2];
        node.left = createTree(a,left,(left + right)/2-1);
        node.right = createTree(a,(left+right)/2+1,right);
        return node;
    }
    private ArrayList<Integer> printFromTopToBottom(Node root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node t = queue.poll();
            list.add(t.value);
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