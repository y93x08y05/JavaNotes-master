package com.jack.algorithm.tree;

/**
 * 反转二叉树，即二叉树的镜像
 */
public class ReverseTree {
    class Node{
        int value;
        Node left = null;
        Node right = null;
        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ReverseTree reverseTree=new ReverseTree();
        int [] arr = {1,2,3,4,5,6,7};
        Node root = reverseTree.createTree(arr,0,arr.length-1);
        reverseTree.invertTree(root);
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
    private Node invertTree(Node root) {
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