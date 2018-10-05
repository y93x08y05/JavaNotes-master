package com.jack.util;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jack on 8/1/2018 10:09 AM
 * 创建一棵二叉树，并对其进行前序中序后序遍历
 */
public class BinaryTree {
    private static Integer [] arr = {1,2,3,4,5,6,7,8,9};
    private static List<TreeNode> list = null;
    public static void main(String [] args) {
        new BinaryTree().createBinaryTree(arr);
        TreeNode node = list.get(0);
        System.out.println("preOrder:");
        new BinaryTree().preOrderTraverse(node);
        System.out.println();
        System.out.println("inOrder");
        new BinaryTree().inOrderTraverse(node);
        System.out.println();
        System.out.println("postOrder");
        new BinaryTree().postOrderTraverse(node);
        System.out.println();
    }
    public void createBinaryTree(Integer [] arr) {
        list = new LinkedList<>();
        for (int i=0;i<arr.length;i++) {
            list.add(new TreeNode(arr[i]));
        }
        for (int i=0;i<arr.length/2-1;i++) {
            list.get(i).left = list.get(i*2+1);
            list.get(i).right = list.get(i*2+2);
        }
        int lastIndex = arr.length/2-1;
        list.get(lastIndex).left = list.get(lastIndex*2+1);
        if (arr.length%2==1) {
            list.get(lastIndex).right = list.get(lastIndex*2+2);
        }
    }
    public TreeNode createTree(Integer [] arr) {
        list = new LinkedList<>();
        for (int i=0;i<arr.length;i++) {
            list.add(new TreeNode(arr[i]));
        }
        for (int i=0;i<arr.length/2-1;i++) {
            list.get(i).left = list.get(i*2+1);
            list.get(i).right = list.get(i*2+2);
        }
        int lastIndex = arr.length/2-1;
        list.get(lastIndex).left = list.get(lastIndex*2+1);
        if (arr.length%2==1) {
            list.get(lastIndex).right = list.get(lastIndex*2+2);
        }
        return list.get(0);
    }
    public void preOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }
    public void inOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.val + " ");
        inOrderTraverse(node.right);
    }
    public void postOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.val + " ");
    }
}
