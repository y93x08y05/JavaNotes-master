package com.jack.leetcode;

import com.jack.util.BinaryTree;
import com.jack.util.TreeNode;

/**
 * @Author: Jack
 * @Date: 2018/10/5 13:18
 * LeetCode 108
 * 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树
 * 一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差
 * 的绝对值不超过1
 * 例：
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int []arr={-10,-3,0,5,9};
        TreeNode res=new SortedArrayToBST().find(arr);
        new BinaryTree().preOrderTraverse(res);
    }
    public TreeNode find(int []arr) {
        if (arr.length==0)
            return null;
        return find(arr,0,arr.length-1);
    }
    public TreeNode find(int []arr,int start,int end) {
        if (start>end)
            return null;
        int mid=start+(end-start)/2;
        TreeNode node=new TreeNode(arr[mid]);
        node.left=find(arr,start,mid-1);
        node.right=find(arr,mid+1,end);
        return node;
    }
}