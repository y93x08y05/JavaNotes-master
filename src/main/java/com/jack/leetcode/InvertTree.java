package com.jack.leetcode;

import com.jack.util.BinaryTreeNew;
import com.jack.util.TreeNode;

/**
 * @Author: Jack
 * @Date: 2018/10/5 13:01
 * LeetCode 226
 * 翻转二叉树
 * 例：
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class InvertTree {
    public static void main(String[] args) {
        Integer[] arr = {0, 4, 2, 7, 1, 3, 6, 9};
        TreeNode node = new BinaryTreeNew().makeBinaryByArray(arr);
        new InvertTree().find(node);
    }
    /*
     * 交换根节点的左右子树
     * 对左右子树分别执行递归翻转
     */
    public TreeNode find(TreeNode root) {
        if (root == null)
            return null;
        TreeNode tempNode = root.left;
        root.left = find(root.right);
        root.right = find(tempNode);
        return root;
    }
}