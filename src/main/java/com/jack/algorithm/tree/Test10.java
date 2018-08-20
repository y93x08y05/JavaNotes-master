package com.jack.algorithm.tree;

/**
 * 实现一个函数判断一棵二叉树是不是对称的
 * 即与二叉树的镜像是不是一样，递归实现
 */
public class Test10 {
    static class Node{
        int val;
        Node left = null;
        Node right = null;
        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7};
        Node root = createTree(arr,0,arr.length-1);
        System.out.println(isSymmetrical(root));

        int [] arr1 = {1,2,3,4,3,2,1};
        Node root1 = createTree(arr1,0,arr1.length-1);
        System.out.println(isSymmetrical(root1));
    }
    public static Node createTree(int [] a , int left , int right) {
        if (left > right) {
            return null;
        }
        Node node = new Node(a[(left + right) / 2]);
        node.val = a[(left + right) / 2];
        node.left = createTree(a,left,(left + right)/2-1);
        node.right = createTree(a,(left+right)/2+1,right);
        return node;
    }
    public static boolean isSymmetrical(Node root) {
        if (root == null) {
            return true;
        }
        return judgeChild(root.left,root.right);
    }
    private static boolean judgeChild(Node left,Node right) {
        if (left == null && right != null) {
            return false;
        }
        if (right == null && left != null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        return (judgeChild(left.left,right.right) && judgeChild(left.right,right.left));
    }
}