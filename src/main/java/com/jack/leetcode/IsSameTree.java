package com.jack.leetcode;

import com.jack.util.BinaryTreeNew;
import com.jack.util.TreeNode;

/**
 * @Author: Jack
 * @Date: 2018/10/5 11:30
 * LeetCode 100
 * 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 例1:
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 * 输出: true
 * 例2:
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 例3:
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 * 输出: false
 */
public class IsSameTree {
    public static void main(String[] args) {
        Integer []arr1={0,1,2};
        Integer []arr2={0,1,0,2};
        TreeNode node1=new BinaryTreeNew().makeBinaryByArray(arr1);
        TreeNode node2=new BinaryTreeNew().makeBinaryByArray(arr2);
        System.out.println(new IsSameTree().find(node1, node2));
    }
    public boolean find(TreeNode root1,TreeNode root2) {
        if (root1==null&&root2==null)
            return true;
        if (root1==null||root2==null)
            return false;
        if (root1.val!=root2.val)
            return false;
        return find(root1.left,root2.left)&&find(root1.right,root2.right);
    }
}