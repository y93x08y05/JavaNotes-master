package com.jack.algorithm.概览.树;

/**
 * 用有序数组生成一颗平衡搜索二叉树
 * 即利用二分法进行递归实现
 * 平衡二叉树的左右子树高度差为1
 */
public class ArrayToBST {
    class Node{
        int value;
        Node left = null;
        Node right = null;
        Node(int value) {
            this.value = value;
        }
    }
    private Node sortedArrayToBST(int [] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        return helper(num,0,num.length-1);
    }
    private Node helper(int [] num,int left,int right) {
        if (left <= right) {
            int mid = left + (right - left)/2;
            Node node = new Node(num[mid]);
            node.left = helper(num,left,mid-1);
            node.right = helper(num,mid+1,right);
            return node;
        } else {
            return null;
        }
    }
    private void printTree(Node root) {
        if (root!=null) {
            System.out.print(root.value+" ");
            printTree(root.left);
            printTree(root.right);
        }
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3};
        ArrayToBST test1 = new ArrayToBST();
        Node root=test1.sortedArrayToBST(arr);
        test1.printTree(root);
    }
}