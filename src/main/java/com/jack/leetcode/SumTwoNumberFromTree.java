package com.jack.leetcode;

import com.jack.util.BinaryTreeCreate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 8/9/2018 2:35 PM
 * LeetCode 653
 * 给定一个二叉搜索树和一个目标结果，
 * 如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 */
public class SumTwoNumberFromTree {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 4, 7};
        int target = 9;
        BinaryTreeCreate binaryTreeCreate = new BinaryTreeCreate();
        BinaryTreeCreate.Node node = binaryTreeCreate.generateTree(arr);
        System.out.println(findTarget(node, target));
    }
    private static boolean findTarget(BinaryTreeCreate.Node root, int target) {
        if (root == null) return false;
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == target) return true;
            if (sum < target)
                i++;
            else
                j--;
        }
        return false;
    }
    private static void inOrder(BinaryTreeCreate.Node root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.value);
        inOrder(root.right, list);
    }
}
