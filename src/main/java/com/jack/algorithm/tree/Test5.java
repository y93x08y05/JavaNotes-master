package com.jack.algorithm.tree;

/**
 * 判断一棵树是不是另一棵二叉树的子树
 */
public class Test5 {
    class Node{
        int value;
        Node left = null;
        Node right = null;
        Node(int value) {
            this.value = value;
        }
    }
    public boolean hasSubTree(Node root1,Node root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSubTree(root1,root2) || hasSubTree(root1.left,root2) ||hasSubTree(root1.right,root2);
    }
    public boolean isSubTree(Node root1,Node root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.value == root2.value) {
            return isSubTree(root1.left,root2.left) && isSubTree(root1.right,root2.right);
        }
        return false;
    }
}