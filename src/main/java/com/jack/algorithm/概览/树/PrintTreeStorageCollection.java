package com.jack.algorithm.概览.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上往下打印二叉树，同一层节点从左到右输出，每一层输出一行
 * 二叉树层次遍历
 * 存放结果集一个集合
 * 临时存放每一层结果使用一个集合
 * 节点使用一个集合
 */
public class PrintTreeStorageCollection {
    class Node{
        int val;
        Node left = null;
        Node right = null;
        Node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        PrintTreeStorageCollection printTree=new PrintTreeStorageCollection();
        int [] arr = {1,2,3,4,5,6,7};
        Node root = printTree.createTree(arr,0,arr.length-1);
        List<List<Integer>> arrayLists = printTree.print(root);
        for (int i=0;i<arrayLists.size();i++) {
            for (int j=0;j<arrayLists.get(i).size();j++) {
                System.out.print(arrayLists.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    private Node createTree(int [] a , int left , int right) {
        if (left > right) {
            return null;
        }
        Node node = new Node(a[(left + right) / 2]);
        node.val = a[(left + right) / 2];
        node.left = createTree(a,left,(left + right)/2-1);
        node.right = createTree(a,(left+right)/2+1,right);
        return node;
    }
    private List<List<Integer>> print(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Queue<Node> queue = new LinkedList<Node>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        int start = 0;
        int end = 1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            end--;
            arrayList.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                start++;
            }
            if (node.right != null) {
                queue.add(node.right);
                start++;
            }
            if (end == 0) {
                result.add(new ArrayList<>(arrayList));
                arrayList.clear();
                end = start;
                start = 0;
            }
        }
        return result;
    }
}