package com.jack.leetcode;

import com.jack.util.BinaryTreeNew;
import com.jack.util.TreeNode;

/**
 * @Author: Jack
 * @Date: 2018/10/5 18:55
 * LeetCode 450
 * 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点root和一个值key，删除二叉搜索树中的key对应的节点
 * 并保证二叉搜索树的性质不变，返回二叉搜索树的根节点的引用。
 * 删除节点可分为两个步骤：
 * 首先找到需要删除的节点
 * 如果找到了，删除它
 * 要求算法时间复杂度O(h)，h为树的高度。
 * 例：
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 */
public class DeleteNodeBST {
    public static void main(String[] args) {
        Integer[] arr = {0, 5, 3, 6, 2, 4, 0, 7};
        int key = 3;
        TreeNode root = new BinaryTreeNew().makeBinaryByArray(arr);
        System.out.println(new DeleteNodeBST().find(root, key));
    }
    public TreeNode find(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key < root.val)
            root.left = find(root.left, key);
        else if (key > root.val)
            root.right = find(root.right, key);
        else {
            if (root.left == null || root.right == null)
                root = root.left != null ? root.left : root.right;
            else {
                TreeNode current = root.right;
                while (current.left != null)
                    current = current.left;
                root.val = current.val;
                root.right = find(root.right, current.val);
            }
        }
        return root;
    }
}