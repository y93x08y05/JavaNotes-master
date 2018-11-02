package com.jack.leetcode;

import com.jack.util.BinaryTreeNew;
import com.jack.util.TreeNode;

/**
 * @Author: Jack
 * @Date: 2018/10/5 20:39
 * LeetCode 129
 * 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个0-9的数字，
 * 每条从根到叶子节点的路径都代表一个数字。
 * 计算从根到叶子节点生成的所有数字之和。
 * 叶子节点是指没有子节点的节点。
 * 例1：
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 例2:
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 */
public class SumNumbersTree {
    private int result = 0;
    private int num = 0;
    public static void main(String[] args) {
        Integer[] arr = {0, 1, 2, 3};
        TreeNode root = new BinaryTreeNew().makeBinaryByArray(arr);
        System.out.println(new SumNumbersTree().find(root));
    }
    public int find(TreeNode root) {
        sum(root);
        return result;
    }
    public void sum(TreeNode root) {
        if (root != null) {
            num = num * 10 + root.val;
            if (root.left == null && root.right == null)
                result += num;
            sum(root.left);
            sum(root.right);
            num /= 10;
        }
    }
}