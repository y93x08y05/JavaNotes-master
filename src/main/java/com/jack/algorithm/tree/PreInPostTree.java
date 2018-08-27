package com.jack.algorithm.tree;

import java.util.Stack;

/**
 * 递归和非递归方式实现二叉树的前序、中序、后序遍历。
 * 用递归方式解决的问题都能用非递归的方式实现
 * 递归方式利用函数栈来保存信息，可用其他数据结构代替函数栈。
 * 非递归方式实现二叉树先序遍历过程：
 * 申请一个新的栈，记为stack。然后将头节点head压入stack中
 * 从stack中弹出栈顶节点，记为current，打印current节点的值
 * 再将current的右孩子压入堆栈，最后将左孩子压入stack
 */
public class PreInPostTree {
    class Node{
        int value;
        Node left = null;
        Node right = null;
        Node(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        PreInPostTree preInPostTree=new PreInPostTree();
        int [] arr = {1,2,3,4,5,6,7};
        Node root = preInPostTree.createTree(arr,0,arr.length-1);
        preInPostTree.preOrder(root);
        preInPostTree.preOrder1(root);
        preInPostTree.inOrder(root);
        preInPostTree.inOrder1(root);
        preInPostTree.postOrder(root);
        preInPostTree.postOrder1(root);
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
    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }
    private void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }
    //非递归的先序遍历
    private void preOrder1(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.value + " ");
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
    }
    //非递归的中序遍历
    private void inOrder1(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.print(root.value + " ");
                    root = root.right;
                }
            }
        }
    }
    //非递归的后序遍历
    private void postOrder1(Node root) {
        if (root != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(root);
            while (!stack1.isEmpty()) {
                root = stack1.pop();
                stack2.push(root);
                if (root.left != null) {
                    stack1.push(root.left);
                }
                if (root.right != null) {
                    stack1.push(root.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value+" ");
            }
        }
    }
}