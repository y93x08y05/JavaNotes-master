package com.jack.leetcode;

import com.jack.util.BinaryTreeCreate;

/**
 * Created by Jack on 8/9/2018 10:36 AM
 * LeetCode 687
 * find longest same value path in binary tree
 */
public class LongestSameValuePath {
    private static int max = 0;
    public static void main(String[] args) {
        int [] arr = {1,4,5,4,4,5};
        BinaryTreeCreate binaryTreeCreate = new BinaryTreeCreate();
        BinaryTreeCreate.Node node = binaryTreeCreate.generateTree(arr);
        System.out.println(longestPath(node));
    }
    private static int longestPath(BinaryTreeCreate.Node node) {
        if (node == null)
            return 0;
        helper(node);
        return max;
    }
    public static int helper(BinaryTreeCreate.Node root) {
        int left = 0, right = 0;
        if (root == null) return 0;
        if (root.left != null) {
            left = helper(root.left);
        }
        if (root.right != null) {
            right = helper(root.right);
        }
        if (root.left == null && root.right == null) {
            return 0;
        } else if (root.left == null) {
            if (root.value == root.right.value) {
                int cur = right + 1;
                if (cur > max) max = cur;
                return cur;
            } else {
                return 0;
            }
        } else if (root.right == null) {
            if (root.value == root.left.value) {
                int cur = left + 1;
                if (cur > max) max = cur;
                return cur;
            } else {
                return 0;
            }
        } else if (root.value != root.left.value && root.value != root.right.value) {
            return 0;
        } else if (root.value == root.left.value && root.value == root.right.value) {
            int cur = left + right + 2;
            if (cur > max) max = cur;
            int curr = Math.max(left, right);
            return curr + 1;
        } else if (root.value == root.left.value) {
            int cur = left + 1;
            if (cur > max) max = cur;
            return cur;
        } else {
            int cur = right + 1;
            if (cur > max) max = cur;
            return cur;
        }
    }
}
