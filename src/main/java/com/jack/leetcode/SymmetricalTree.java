package com.jack.leetcode;

/**
 * Created by Jack on 8/27/2018 2:51 PM
 * LeetCode 101
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class SymmetricalTree {
    class Node{
        int val;
        Node left = null;
        Node right = null;
        Node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        SymmetricalTree symmetricalTree=new SymmetricalTree();
        int [] arr1 = {1,2,3,4,5,6,7};
        Node root = symmetricalTree.createTree(arr1,0,arr1.length-1);
        System.out.println(symmetricalTree.isSymmetrical(root));
        int [] arr2 = {1,2,3,4,3,2,1};
        Node root1 = symmetricalTree.createTree(arr2,0,arr2.length-1);
        System.out.println(symmetricalTree.isSymmetrical(root1));
    }
    private Node createTree(int [] a , int left , int right) {
        if (left > right) {
            return null;
        }
        Node node = new Node(a[(left + right) / 2]);
        node.val = a[(left + right) / 2];
        node.left = createTree(a,left,(left + right)/2-1);
        node.right = createTree(a,(left+right)/2+1,right);
        return node;
    }
    private boolean isSymmetrical(Node root) {
        if (root == null) {
            return true;
        }
        return judgeChild(root.left,root.right);
    }
    private boolean judgeChild(Node left,Node right) {
        if (left == null && right != null)
            return false;
        if (right == null && left != null)
            return false;
        if (left == null && right == null)
            return true;
        if (left.val != right.val)
            return false;
        return (judgeChild(left.left,right.right) && judgeChild(left.right,right.left));
    }
}
