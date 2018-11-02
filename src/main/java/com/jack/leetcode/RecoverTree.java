package com.jack.leetcode;

import com.jack.util.BinaryTreeNew;
import com.jack.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jack
 * @Date: 2018/10/5 22:33
 * LeetCode 99
 * 恢复二叉搜索树
 * 二叉搜索树中的两个节点被错误的交换
 * 在不改变其结构的情况下，恢复这棵树
 * 例1:
 * 输入: [1,3,null,null,2]
 *    1
 *   /
 *  3
 *   \
 *    2
 * 输出: [3,1,null,null,2]
 *    3
 *   /
 *  1
 *   \
 *    2
 * 例2:
 * 输入: [3,1,4,null,null,2]
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 * 输出: [2,1,4,null,null,3]
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 */
public class RecoverTree {
    public static void main(String[] args) {
        Integer []arr = {0,3,1,4,0,0,2};
        new RecoverTree().find(new BinaryTreeNew().makeBinaryByArray(arr));
    }
    List<TreeNode> list;
    public void find(TreeNode root) {
        list = new ArrayList<>();
        inOrder(root);
        int size = list.size();
        TreeNode first = null, second = null;
        for (int i = 0; i < size - 1; i++) {
            TreeNode prev = list.get(i);
            TreeNode next = list.get(i + 1);
            if (prev.val > next.val) {
                if (first == null) {
                    first = prev;
                    second = next;
                } else
                    second = next;
            }
        }
        int val = first.val;
        first.val = second.val;
        second.val = val;
    }
    public void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        list.add(root);
        inOrder(root.right);
    }
}