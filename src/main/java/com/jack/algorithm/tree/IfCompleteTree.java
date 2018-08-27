package com.jack.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一棵树是否是完全二叉树
 * 按层遍历二叉树，从每层的左边向右边依次遍历所有的节点
 * 如果当前节点有右孩子但是没有左孩子，直接返回false
 * 如果当前节点并不是左右孩子全有，那之后的节点必须都为叶节点，否则返回false
 * 遍历过程中如果不返回false，遍历结束后返回true
 */
public class IfCompleteTree {
    class Node {
        int value;
        Node left = null;
        Node right = null;
        Node(int value){
            this.value = value;
        }
    }
    public static void main(String[] args) {
        IfCompleteTree ifCompleteTree=new IfCompleteTree();
        int [] arr = {1,2,3,4,5,6,7};
        Node root = ifCompleteTree.createTree(arr,0,arr.length-1);
        System.out.println(ifCompleteTree.isCompleteTree(root));
    }
    public boolean isCompleteTree(Node root) {
        if (root == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node left;
        Node right;
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            left = root.left;
            right = root.right;
            if ((leaf && (left != null || right != null)) ||
                    (left == null || right != null)) {
                return false;
            }
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            } else {
                leaf = true;
            }
        }
        return true;
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
}