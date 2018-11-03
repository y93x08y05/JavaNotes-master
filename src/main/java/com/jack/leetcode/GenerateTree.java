package com.jack.leetcode;

import com.jack.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/5 22:04
 * LeetCode 95
 * 不同的二叉搜索树2
 * 给定一个整数n，生成所有由1...n为节点所组成的二叉搜索树
 * 例：
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class GenerateTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(new GenerateTree().find(n));
    }
    private List<TreeNode> find(int n) {
        if (n == 0)
            return new ArrayList<>();
        return helper(1, n);
    }
    private List<TreeNode> helper(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftList = helper(left, i - 1);
            List<TreeNode> rightList = helper(i + 1, right);
            for (int j = 0; j < leftList.size(); j++) {
                for (int k = 0; k < rightList.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftList.get(j);
                    root.right = rightList.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}