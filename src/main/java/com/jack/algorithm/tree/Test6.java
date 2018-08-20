package com.jack.algorithm.tree;

/**
 * 反转二叉树，即二叉树的镜像
 */
public class Test6 {
    class Node{
        int value;
        Node left = null;
        Node right = null;
        Node(int value) {
            this.value = value;
        }
    }
    public Node invertTree(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}