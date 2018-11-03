package com.jack.leetcode;

import com.jack.util.BinaryTreeNew;
import com.jack.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Jack
 * @Date: 2018/10/5 21:10
 * LeetCode 98
 * 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 二叉搜索树有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须是二叉搜索树。
 * 例1：
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 例2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class IsValidBST {
    public static void main(String[] args) {
        Integer[] arr = {0, 2, 1, 3};
        TreeNode root = new BinaryTreeNew().makeBinaryByArray(arr);
        System.out.println(new IsValidBST().find(root));
    }
    public boolean find(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        int len = list.size();
        for (int i = 0; i < len - 1; i++)
            if (list.get(i) >= list.get(i + 1))
                return false;
        return true;
    }
}