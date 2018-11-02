package com.jack.leetcode;

import com.jack.util.BinaryTreeNew;
import com.jack.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jack
 * @Date: 2018/10/5 14:10
 * LeetCode 113
 * 路径总和3
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点
 * 路径总和等于给定目标和的路径。
 * 叶子节点是指没有子节点的节点。
 * 例：
 * 给定如下二叉树，以及目标和sum=22
 *                5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSumTree2 {
    public static void main(String[] args) {
        Integer[] arr = {0, 5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 0, 0, 5, 1};
        int sum = 22;
        TreeNode node = new BinaryTreeNew().makeBinaryByArray(arr);
        System.out.println(new PathSumTree2().find(node, sum));
    }
    public List<List<Integer>> find(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (root == null)
            return result;
        dfs(result, temp, root, sum);
        return result;
    }
    public void dfs(List<List<Integer>> result, List<Integer> temp, TreeNode root, int sum) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            temp.add(root.val);
            if (find(temp) == sum)
                result.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
        } else {
            temp.add(root.val);
            dfs(result, temp, root.left, sum);
            dfs(result, temp, root.right, sum);
            temp.remove(temp.size() - 1);
        }
    }
    public int find(List<Integer> temp) {
        int sum = 0;
        for (int i = 0; i < temp.size(); i++)
            sum += temp.get(i);
        return sum;
    }
}