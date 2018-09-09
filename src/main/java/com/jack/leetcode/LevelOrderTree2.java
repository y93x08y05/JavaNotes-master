package com.jack.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Jack on 8/27/2018 2:08 PM
 * LeetCode 107
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class LevelOrderTree2 {
    class Node{
        int val;
        Node left = null;
        Node right = null;
        Node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        LevelOrderTree2 printTree=new LevelOrderTree2();
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
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
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
        List<List<Integer>> lists=new ArrayList<>();
        for (int i=result.size()-1;i>=0;i--) {
            lists.add(result.get(i));
        }
        return lists;
    }
}
