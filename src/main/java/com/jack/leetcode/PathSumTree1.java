package com.jack.leetcode;

import com.jack.util.BinaryTreeNew;
import com.jack.util.TreeNode;

/**
 * @Author: Jack
 * @Date: 2018/10/5 13:42
 * LeetCode 112
 * 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和。
 * 叶子节点是指没有子节点的节点。
 * 例：
 * 给定二叉树以及目标和sum=22
 *                5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class PathSumTree1 {
    public static void main(String[] args) {
        Integer []arr={0,5,4,8,11,13,4,7,2,0,1};
        TreeNode node=new BinaryTreeNew().makeBinaryByArray(arr);
        System.out.println(new PathSumTree1().find(node));
    }
    public boolean find(TreeNode root) {
        int sum=22;
        return find(root,sum);
    }
    public boolean find(TreeNode root,int sum) {
        if (root==null)
            return false;
        if (root.left==null&&root.right==null&&sum==root.val)
            return true;
        else
            return find(root.left,sum-root.val)||find(root.right,sum-root.val);
    }
}