package com.jack.leetcode;

import java.util.*;

/**
 * Created by Jack on 8/27/2018 2:02 PM
 * LeetCode 102
 * 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。
 * （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrderTree1 {
    class Node{
        int val;
        Node left = null;
        Node right = null;
        Node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        LevelOrderTree1 printTree = new LevelOrderTree1();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node root = printTree.createTree(arr, 0, arr.length - 1);
        List<List<Integer>> arrayLists = printTree.print(root);
        for (int i = 0; i < arrayLists.size(); i++) {
            for (int j = 0; j < arrayLists.get(i).size(); j++) {
                System.out.print(arrayLists.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    private Node createTree(int[] a , int left, int right) {
        if (left > right) {
            return null;
        }
        Node node = new Node(a[(left + right) / 2]);
        node.val = a[(left + right) / 2];
        node.left = createTree(a, left, (left + right) / 2 - 1);
        node.right = createTree(a, (left + right) / 2 + 1, right);
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
            arrayList.add(Objects.requireNonNull(node).val);
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
