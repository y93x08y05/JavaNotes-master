package com.jack.util;

/**
 * @Author: Jack
 * @Date: 2018/10/5 10:43
 */
public class BinaryTreeNew {
    public static TreeNode root;
    public BinaryTreeNew(){}
    public TreeNode makeBinaryByArray(Integer [] arr){
        root = makeBinaryByArray(arr,1);
        return root;
    }
    public TreeNode makeBinaryByArray(Integer [] arr,int index){
        if (index<arr.length){
            Integer value = arr[index];
            if (value != 0){
                TreeNode t = new TreeNode(value);
                arr[index] = 0;
                t.left = makeBinaryByArray(arr,index*2);
                t.right = makeBinaryByArray(arr,index*2+1);
                return t;
            }
        }
        return null;
    }
    public static void main(String [] args){
        Integer [] arr = {0,1,0,2,0,0,3};
        BinaryTreeNew tree = new BinaryTreeNew();
        tree.makeBinaryByArray(arr);
        tree.preOrderTraverse(root);
        System.out.println();
        tree.inOrderTraverse(root);
        System.out.println();
        tree.postOrderTraverse(root);
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