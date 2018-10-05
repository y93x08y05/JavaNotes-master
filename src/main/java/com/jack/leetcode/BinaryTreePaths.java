package com.jack.leetcode;

import com.jack.util.BinaryTreeNew;
import com.jack.util.TreeNode;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/10/5 15:37
 * LeetCode 257
 * 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径
 * 叶子节点是指没有子节点的节点
 * 例：
 * 输入:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        Integer []arr={0,1,2,3,0,5};
        TreeNode node=new BinaryTreeNew().makeBinaryByArray(arr);
        System.out.println(new BinaryTreePaths().find1(node));
        System.out.println(new BinaryTreePaths().find2(node));
        System.out.println(new BinaryTreePaths().find3(node));
        System.out.println(new BinaryTreePaths().find4(node));
        System.out.println(new BinaryTreePaths().find5(node));
    }
    public List<String> result=new ArrayList<>();
    public List<String> find1(TreeNode root) {
        if (root==null)
            return result;
        findPaths(root,root.val+"");
        return result;
    }
    public List<String> find2(TreeNode root) {
        findPath(root,new StringBuilder());
        return result;
    }
    public List<String> find3(TreeNode root) {
        if (root==null)
            return result;
        Stack<Wrapper> stack=new Stack<>();
        stack.add(new Wrapper(root,root.val+""));
        Wrapper wrapper;
        while (!stack.isEmpty()) {
            wrapper=stack.pop();
            if (wrapper.node.left==null&&wrapper.node.right==null)
                result.add(wrapper.path);
            if (wrapper.node.left!=null)
                stack.add(new Wrapper(wrapper.node.left,wrapper.path+"->"+wrapper.node.left.val));
            if (wrapper.node.right!=null)
                stack.add(new Wrapper(wrapper.node.right,wrapper.path+"->"+wrapper.node.right.val));
        }
        return result;
    }
    public List<String> find4(TreeNode root) {
        if (root==null)
            return result;
        Queue<TreeNode> nodeQueue=new LinkedList<>();
        Queue<String> pathQueue=new LinkedList<>();
        nodeQueue.offer(root);
        pathQueue.offer(root.val+"");
        while (!nodeQueue.isEmpty()) {
            TreeNode currentNode=nodeQueue.poll();
            String item=pathQueue.poll();
            if (currentNode.left==null&&currentNode.right==null)
                result.add(item);
            if (currentNode.left!=null) {
                nodeQueue.offer(currentNode.left);
                pathQueue.offer(item+"->"+currentNode.left.val);
            }
            if (currentNode.right!=null) {
                nodeQueue.offer(currentNode.right);
                pathQueue.offer(item+"->"+currentNode.right.val);
            }
        }
        return result;
    }
    public List<String> find5(TreeNode root) {
        List<String> pathList=new ArrayList<>();
        if (root==null)
            return pathList;
        if (root.left==null&&root.right==null) {
            pathList.add(root.val+"");
            return pathList;
        }
        for (String path:find5(root.left))
            pathList.add(root.val+"->"+path);
        for (String path:find5(root.right))
            pathList.add(root.val+"->"+path);
        return pathList;
    }
    public void findPath(TreeNode node,StringBuilder sb) {
        if (node==null)
            return;
        int len=sb.length();
        sb.append(node.val);
        if (node.left==null&&node.right==null)
            result.add(sb.toString());
        else {
            sb.append("->");
            findPath(node.left,sb);
            findPath(node.right,sb);
        }
        sb.setLength(len);
    }
    public void findPaths(TreeNode node,String path) {
        if (node.left==null&&node.right==null)
            result.add(path);
        if (node.left!=null)
            findPaths(node.left,path+"->"+node.left.val);
        if (node.right!=null)
            findPaths(node.right,path+"->"+node.right.val);
    }
    private static class Wrapper {
        TreeNode node;
        String path;
        public Wrapper() {

        }
        public Wrapper(TreeNode node) {
            this.node=node;
        }
        public Wrapper(TreeNode node,String path) {
            this.node=node;
            this.path=path;
        }
    }
}