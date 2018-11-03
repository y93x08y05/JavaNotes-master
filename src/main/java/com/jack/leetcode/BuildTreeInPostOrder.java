package com.jack.leetcode;

/**
 * Created by Jack on 8/27/2018 3:11
 * LeetCode 106
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 你可以假设树中没有重复的元素。
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 */
public class BuildTreeInPostOrder {
    class Node{
        int val;
        Node left = null;
        Node right = null;
        Node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        BuildTreeInPostOrder constructTree = new BuildTreeInPostOrder();
        int[] post = {4, 5, 2, 6, 7, 3, 1};
        int[] in = {4, 2, 5, 1, 6, 3, 7};
        Node root = constructTree.reConstructTree(in, post);
        constructTree.print(root);
    }
    private void print(Node root) {
        if (null == root) {
            return;
        }
        System.out.print(root.val + " ");
        print(root.left);
        print(root.right);
    }
    private Node reConstructTree(int[] in, int[] post) {
        Node root = reConstruct(post, 0, post.length - 1, in, 0, in.length - 1);
        return root;
    }
    private Node reConstruct(int[] post, int startPost, int endPost, int[] in, int startIn, int endIn) {
        if (startPost > endPost || startIn > endIn) {
            return null;
        }
        Node root = new Node(post[endPost]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == post[endPost]) {
                root.left = reConstruct(post, startPost, startPost + (i - startIn - 1), in, startIn, i - 1);
                root.right = reConstruct(post, startPost + (i - startIn), endPost - 1, in, i + 1, endIn);
            }
        }
        return root;
    }
}
