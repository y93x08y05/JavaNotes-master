package com.jack.leetcode;

import com.jack.util.BinaryTreeNew;
import com.jack.util.TreeNode;

/**
 * @Author: Jack
 * @Date: 2018/10/5 18:38
 * LeetCode 701
 * 二叉搜索树中的插入操作
 * 给定二叉搜索树的根节点和要插入树中的值，将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。
 * 保证原二叉搜索树中不存在新值。
 * 可能存在多种有效的插入方式，只要树在插入后仍保持为
 * 二叉搜索树即可。
 * 例：
 * 给定二叉搜索树:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * 或者这个树也是有效的:
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 */
public class InsertIntoBST {
    public static void main(String[] args) {
        Integer[]arr = {0, 4, 2, 7, 1, 3};
        TreeNode root = new BinaryTreeNew().makeBinaryByArray(arr);
        int val = 5;
        System.out.println(new InsertIntoBST().find(root, val).val);
    }
    public TreeNode find(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        TreeNode ptr = root;
        while (true) {
            if (val < ptr.val) {
                if (ptr.left == null) {
                    ptr.left = new TreeNode(val);
                    break;
                } else
                    ptr = ptr.left;
            } else {
                if (ptr.right == null) {
                    ptr.right = new TreeNode(val);
                    break;
                } else
                    ptr = ptr.right;
            }
        }
        return root;
    }
}