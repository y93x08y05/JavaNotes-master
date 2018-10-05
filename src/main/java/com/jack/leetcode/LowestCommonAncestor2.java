package com.jack.leetcode;

import com.jack.util.BinaryTreeNew;
import com.jack.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jack
 * @Date: 2018/10/5 16:44
 * LeetCode 236
 * 二叉树的最近公共祖先，找到该树中两个指针节点的最近公共祖先。
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *         _______3______
 *        /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *    6      _2       0       8
 *          /  \
 *          7   4
 * 例1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 例2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。
 * 因为根据定义最近公共祖先节点可以为节点本身。
 */
public class LowestCommonAncestor2 {
    public static void main(String[] args) {
        Integer []arr={0,3,5,1,6,2,0,8,0,0,7,4};
        TreeNode root=new BinaryTreeNew().makeBinaryByArray(arr);
        TreeNode p=new TreeNode(5);
        TreeNode q=new TreeNode(1);
        System.out.println(new LowestCommonAncestor2().find(root,p,q).val);
    }
    public TreeNode find(TreeNode root,TreeNode p,TreeNode q) {
        if (root==null||p==null||q==null)
            return null;
        List<TreeNode> pathP=new ArrayList<>();
        List<TreeNode> pathQ=new ArrayList<>();
        pathP.add(root);
        pathQ.add(root);
        getPath(root,p,pathP);
        getPath(root,q,pathQ);
        TreeNode lca=null;
        for (int i=0;i<pathP.size()&&i<pathQ.size();i++) {
            if (pathP.get(i)==pathQ.get(i))
                lca=pathP.get(i);
            else
                break;
        }
        return lca;
    }
    public boolean getPath(TreeNode root,TreeNode n,List<TreeNode> path) {
        if (root==n)
            return true;
        if (root.left!=null) {
            path.add(root.left);
            if (getPath(root.left,n,path))
                return true;
            path.remove(path.size()-1);
        }
        if (root.right!=null) {
            path.add(root.right);
            if (getPath(root.right,n,path))
                return true;
            path.remove(path.size()-1);
        }
        return false;
    }
}