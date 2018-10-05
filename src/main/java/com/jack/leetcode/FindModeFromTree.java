package com.jack.leetcode;

import com.jack.util.BinaryTreeNew;
import com.jack.util.TreeNode;

/**
 * @Author: Jack
 * @Date: 2018/10/5 21:20
 * LeetCode 501
 * 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树，找出BST中的所有众数，即出现频率最高的元素
 * BST定义如下：
 * （1）结点左子树中所有结点的值小于等于当前结点的值
 * （2）结点右子树中所有结点的值大于等于当前结点的值
 * （3）左子树和右子树都是二叉搜索树
 * 例1：
 * 给定 BST [1,null,2,2],
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 */
public class FindModeFromTree {
    private int max=0;
    private int currVal=0;
    private int currCount=0;
    private int currModes=0;
    private int [] modes;
    public static void main(String[] args) {
        Integer []arr={0,1,0,2,0,0,2};
        TreeNode root=new BinaryTreeNew().makeBinaryByArray(arr);
        int []res=new FindModeFromTree().find(root);
        for (int i=0;i<res.length;i++) {
            System.out.println(res[i]);
        }
    }
    public int [] find(TreeNode root) {
        helper(root);
        modes=new int[currModes];
        currCount=0;
        currModes=0;
        helper(root);
        return modes;
    }
    public void helper(TreeNode root) {
        if (root==null)
            return;
        helper(root.left);
        if (root.val!=currVal) {
            currVal=root.val;
            currCount=1;
        } else
            currCount++;
        if (currCount>max) {
            max=currCount;
            currModes=1;
        } else if (currCount==max) {
            if (modes!=null)
                modes[currModes]=root.val;
            currModes++;
        }
        helper(root.right);
    }
}