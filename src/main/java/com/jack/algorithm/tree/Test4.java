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
public class Test4 {
    class Node{
        int value;
        Node left = null;
        Node right = null;
        Node(int value) {
            this.value = value;
        }
    }
    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.value + " ");
        inOrder(root.right);
    }
    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value + " ");
    }
    //非递归的先序遍历
    public void preOrder1(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                System.out.println(root.value + " ");
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
    public void inOrder1(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.println(root.value + " ");
                    root = root.right;
                }
            }
        }
    }
    //非递归的后序遍历
    public void postOrder1(Node root) {
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
                System.out.println(stack2.pop().value);
            }
        }
    }
}