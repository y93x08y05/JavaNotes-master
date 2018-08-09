package com.jack.util;

/**
 * Created by Jack on 8/9/2018 10:26 AM
 * generate balance binary tree using sorted array
 */
public class BinaryTreeCreate {
    public class Node{
        public int value;
        public Node left = null;
        public Node right = null;
        public Node(int value) {
            this.value = value;
        }
    }
    public Node generateTree(int [] arr) {
        if (arr == null)
            return null;
        return generateTree(arr,0);
    }
    public Node generateTree(int [] arr,int start) {
        Node root = null;
        if (start < arr.length) {
            int value = arr[start];
            root = new Node(value);
            root.left = generateTree(arr,2*start+1);
            root.right = generateTree(arr,2*start+2);
            return root;
        }
        return root;
    }
}
