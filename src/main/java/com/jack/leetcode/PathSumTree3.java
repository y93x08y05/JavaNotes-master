package com.jack.leetcode;

import com.jack.util.BinaryTreeNew;
import com.jack.util.TreeNode;

/**
 * @Author: Jack
 * @Date: 2018/10/5 14:32
 * LeetCode 437
 * 路径总和3
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向
 * 必须是向下的。只能从父节点到子节点。
 * 二叉树不超过1000个节点，且节点数值范围是[-1000000,1000000]的整数。
 * 例：
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 * 返回 3。和等于 8 的路径有:
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */
public class PathSumTree3 {
    public static void main(String[] args) {
        Integer []arr={0,10,5,-3,3,2,0,11,3,-2,0,1};
        int sum=8;
        TreeNode node=new BinaryTreeNew().makeBinaryByArray(arr);
        System.out.println(new PathSumTree3().find(node,sum));
    }
    public int find(TreeNode root,int sum) {
        if (root==null)
            return 0;
        return dfs(root,sum)+find(root.left,sum)+find(root.right,sum);
    }
    public int dfs(TreeNode root,int sum) {
        int res=0;
        if (root==null)
            return res;
        if (sum==root.val)
            res++;
        res+=dfs(root.left,sum-root.val);
        res+=dfs(root.right,sum-root.val);
        return res;
    }
}