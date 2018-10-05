package com.jack.leetcode;

import com.jack.util.BinaryTreeNew;
import com.jack.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Jack
 * @Date: 2018/10/5 10:06
 * LeetCode 94
 * 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序遍历
 * 例：
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [1,3,2]
 */
public class InorderTraversal {
    public static void main(String[] args) {
        Integer []arr={0,1,0,2,0,0,3};
        TreeNode node=new BinaryTreeNew().makeBinaryByArray(arr);
        List<Integer> res1=new InorderTraversal().find0(node);
        System.out.println(res1);
        List<Integer> res2=new InorderTraversal().find1(node);
        System.out.println(res2);
    }
    public List<Integer> list=new ArrayList<>();
    public List<Integer> find0(TreeNode root) {
        inOrder(root);
        return list;
    }
    public List<Integer> find1(TreeNode root) {
        if (root==null)
            return list;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode tempNode=root;
        stack.push(tempNode);
        while (!stack.isEmpty()) {
            while ((tempNode=stack.peek())!=null) {
                tempNode=tempNode.left;
                stack.push(tempNode);
            }
            stack.pop();
            if (!stack.isEmpty()) {
                tempNode=stack.pop();
                list.add(tempNode.val);
                stack.push(tempNode.right);
            }
        }
        return list;
    }
    public void inOrder(TreeNode node) {
        if (node==null)
            return;
        if (node.left!=null)
            inOrder(node.left);
        list.add(node.val);
        if (node.right!=null)
            inOrder(node.right);
    }
}