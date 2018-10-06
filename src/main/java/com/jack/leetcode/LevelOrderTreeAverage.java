package com.jack.leetcode;

import com.jack.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Jack on 8/27/2018 2:28 PM
 * LeetCode 637
 *  二叉树的层平均值
 *  给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 */
public class LevelOrderTreeAverage {
    public static void main(String[] args) {
        LevelOrderTreeAverage printTree=new LevelOrderTreeAverage();
        int [] arr = {1,2,3,4,5,6,7};
        TreeNode root = printTree.createTree(arr,0,arr.length-1);
        List<Double> lists = printTree.print(root);
        for (int i=0;i<lists.size();i++) {
            System.out.println(lists.get(i));
        }
    }
    private TreeNode createTree(int [] a , int left , int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(a[(left + right) / 2]);
        node.val = a[(left + right) / 2];
        node.left = createTree(a,left,(left + right)/2-1);
        node.right = createTree(a,(left+right)/2+1,right);
        return node;
    }
    private List<Double> print(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        List<Double> lists=new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        queue.add(root);
        int start = 0;
        int end = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
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
        for (int i=0;i<result.size();i++) {
            double average=0;
            for (int j=0;j<result.get(i).size();j++) {
                average+=result.get(i).get(j);
            }
            average/=result.get(i).size();
            lists.add(average);
        }
        return lists;
    }
}
