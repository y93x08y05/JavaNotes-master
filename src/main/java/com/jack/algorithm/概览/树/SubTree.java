package com.jack.algorithm.概览.树;

/**
 * 判断一棵树是不是另一棵二叉树的子树
 */
public class SubTree {
    class Node{
        int value;
        Node left = null;
        Node right = null;
        Node(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        SubTree subTree=new SubTree();
        int [] arr = {1,2,3,4,5,6,7};
        Node root1 = subTree.createTree(arr,0,arr.length-1);
        Node root2 = subTree.createTree(arr,0,1);
        System.out.println(subTree.hasSubTree(root1, root2));
    }
    private Node createTree(int [] a , int left , int right) {
        if (left > right) {
            return null;
        }
        Node node = new Node(a[(left + right) / 2]);
        node.value = a[(left + right) / 2];
        node.left = createTree(a,left,(left + right)/2-1);
        node.right = createTree(a,(left+right)/2+1,right);
        return node;
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