package com.jack.leetcode;

import com.jack.util.BinaryTreeNew;
import com.jack.util.TreeNode;

/**
 * @Author: Jack
 * @Date: 2018/10/5 16:21
 * LeetCode 235
 * 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树，找到该树中两个指定节点的最近公共祖先。
 * 最近公共祖先定义为：对于有根树T的两个结点p、q，最近公共祖先表示为一个结点x，
 * 满足x是p、q的祖先且x的深度尽可能大（一个节点也可以是它自己的祖先）
 * 给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *         _______6______
 *        /              \
 *     ___2__          ___8__
 *    /      \        /      \
 *    0      _4       7       9
 *          /  \
 *          3   5
 * 例1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 例2:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2,
 * 因为根据定义最近公共祖先节点可以为节点本身。
 */
public class LowestCommonAncestor1 {
    public static void main(String[] args) {
        Integer []arr={6,2,8,0,4,7,9,0,0,3,5};
        TreeNode root=new BinaryTreeNew().makeBinaryByArray(arr);
        TreeNode p=new TreeNode(2);
        TreeNode q=new TreeNode(4);
        System.out.println(new LowestCommonAncestor1().find(root,p,q).val);
    }
    public TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null||p==null||q==null)
            return null;
        if (Math.max(p.val,q.val)<root.val)
            return find(root.left,p,q);
        else if (Math.min(p.val,q.val)>root.val)
            return find(root.right,p,q);
        else
            return root;
    }
}