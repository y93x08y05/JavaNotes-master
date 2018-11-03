package com.jack.leetcode;

import java.util.*;

/**
 * Created by Jack on 8/27/2018 2:22 PM
 * LeetCode 103
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class LevelOrderTreeZigzag {
    class Node{
        int value;
        Node left = null;
        Node right = null;
        Node(int val) {
            this.value = val;
        }
    }

    public static void main(String[] args) {
        LevelOrderTreeZigzag printTree = new LevelOrderTreeZigzag();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node root = printTree.createTree(arr, 0, arr.length - 1);
        List<List<Integer>> lists = printTree.print(root);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    private Node createTree(int[] a, int left, int right) {
        if (left > right) {
            return null;
        }
        Node node = new Node(a[(left + right) / 2]);
        node.value = a[(left + right) / 2];
        node.left = createTree(a, left, (left + right) / 2 - 1);
        node.right = createTree(a, (left+right) / 2 + 1, right);
        return node;
    }
    private List<List<Integer>> print(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        int rows = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node t = queue.poll();
                if (rows % 2 == 0) {
                    list.add(0, Objects.requireNonNull(t).value);
                } else {
                    list.add(Objects.requireNonNull(t).value);
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
