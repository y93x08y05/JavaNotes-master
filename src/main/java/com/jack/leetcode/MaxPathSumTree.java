package com.jack.leetcode;

import com.jack.util.BinaryTreeNew;
import com.jack.util.TreeNode;

/**
 * @Author: Jack
 * @Date: 2018/10/5 19:45
 * LeetCode 124
 * 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * 路径被定义为一条从树中任意节点出发，达到任意节点的序列。
 * 该路径至少包含一个节点，且不一定经过根节点。
 * 例1:
 * 输入: [1,2,3]
 *        1
 *       / \
 *      2   3
 * 输出: 6
 * 例2:
 * 输入: [-10,9,20,null,null,15,7]
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: 42
 */
public class MaxPathSumTree {
    int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Integer[] arr = {0, -10, 9, 20, 0, 0, 15, 7};
        TreeNode root = new BinaryTreeNew().makeBinaryByArray(arr);
        System.out.println(new MaxPathSumTree().find(root));
    }
    /*
     * 动态规划，对每一个节点，以该节点为根节点的最大值设为value，
     * 其左子树的路径最大值为leftMax，右子树的路径最大值为rightMax。
     * leftMax和rightMax指的是从左、右子节点出发的某一条单向路径。
     * 公式有：value=value+(leftMax>0?leftMax:0)+(rightMax>0?rightMax:0)
     */
    public int find(TreeNode root) {
        if (root == null)
            return 0;
        getMaxSumNode(root);
        return maxSum;
    }
    public int getMaxSumNode(TreeNode currentNode) {
        int leftMax = 0;
        int rightMax = 0;
        int value = currentNode.val;
        if (currentNode.left != null)
            leftMax = getMaxSumNode(currentNode.left);
        if (currentNode.right != null)
            rightMax = getMaxSumNode(currentNode.right);
        value = value + (leftMax > 0 ? leftMax : 0) + (rightMax > 0 ? rightMax : 0);
        if (value > maxSum)
            maxSum = value;
        return currentNode.val + Math.max(leftMax > 0 ? leftMax : 0, rightMax > 0 ? rightMax : 0);
    }
}