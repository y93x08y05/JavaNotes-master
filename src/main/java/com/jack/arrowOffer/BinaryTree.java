package com.jack.arrowOffer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jack on 8/1/2018 10:09 AM
 */
public class BinaryTree {
    private static int [] arr = {1,2,3,4,5,6,7,8,9};
    private static List<Node> list = null;
    private static class Node{
        Node left;
        Node right;
        int data;
        Node(int data) {
            left = null;
            right = null;
            this.data = data;
        }
    }
    public static void main(String [] args) {
        createBinaryTree(arr);
        Node node = list.get(0);
        System.out.println("preOrder:");
        preOrderTraverse(node);
        System.out.println();
        System.out.println("inOrder");
        inOrderTraverse(node);
        System.out.println();
        System.out.println("postOrder");
        postOrderTraverse(node);
        System.out.println();
    }
    private static void createBinaryTree(int [] arr) {
        list = new LinkedList<Node>();
        for (int i=0;i<arr.length;i++) {
            list.add(new Node(arr[i]));
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
    public static void preOrderTraverse(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }
    public static void inOrderTraverse(Node node) {
        if (node == null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.data + " ");
        inOrderTraverse(node.right);
    }
    public static void postOrderTraverse(Node node) {
        if (node == null)
            return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.data + " ");
    }
}
