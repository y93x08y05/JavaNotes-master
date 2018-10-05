package com.jack.leetcode;

import com.jack.util.BinaryTreeNew;
import com.jack.util.TreeNode;

/**
 * @Author: Jack
 * @Date: 2018/10/5 18:20
 * LeetCode 700
 * 二叉搜索树的搜索
 * 给定二叉搜索树的根节点和一个值，需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树，如果节点不存在，则返回NULL。
 * 例：
 * 给定二叉搜索树:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * 和值: 2
 * 你应该返回如下子树:
 *       2
 *      / \
 *     1   3
 */
public class SearchBST {
    public static void main(String[] args) {
        Integer []arr={0,4,2,7,1,3};
        TreeNode root=new BinaryTreeNew().makeBinaryByArray(arr);
        int val=2;
        System.out.println(new SearchBST().find(root, val).val);
    }
    public TreeNode find(TreeNode root,int val) {
        if (root==null)
            return null;
        if (root.val==val)
            return root;
        else if (root.val<val)
            return find(root.right,val);
        else
            return find(root.left,val);
    }
}