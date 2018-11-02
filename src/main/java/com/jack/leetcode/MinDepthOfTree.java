package com.jack.leetcode;

import com.jack.util.BinaryTreeNew;
import com.jack.util.TreeNode;

/**
 * @Author: Jack
 * @Date: 2018/10/5 13:33
 * LeetCode 111
 * 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 叶子节点是指没有子节点的节点。
 */
public class MinDepthOfTree {
    public static void main(String[] args) {
        Integer[] arr = {0,3,9,20,0,0,15,7};
        TreeNode node = new BinaryTreeNew().makeBinaryByArray(arr);
        System.out.println(new MinDepthOfTree().find(node));
    }
    public int find(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (root.left == null)
            return find(root.right) + 1;
        if (root.right == null)
            return find(root.left) + 1;
        return Math.min(find(root.left) + 1, find(root.right) + 1);
    }
}