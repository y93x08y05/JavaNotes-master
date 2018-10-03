package com.jack.algorithm.概览.树;

import java.util.ArrayDeque;

public class TreeDepthWidth {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value){
            this.value = value;
        }
    }
    TreeNode root;
    public TreeDepthWidth(int [] array){
        root = makeBinaryByArray(array,1);
    }
    public static TreeNode makeBinaryByArray(int [] array,int index){
        if (index<array.length){
            int value = array[index];
            if (value != 0){
                TreeNode t = new TreeNode(value);
                array[index] = 0;
                t.left = makeBinaryByArray(array,index*2);
                t.right = makeBinaryByArray(array,index*2+1);
                return t;
            }
        }
        return null;
    }
    /**
     * 深度优先遍历-先根遍历，非递归实现，辅助栈
     */
    public void depthOrderTraversal(){
        if (root == null){
            System.out.println("empty 树");
            return;
        }
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<TreeNode>();
        arrayDeque.push(root);
        while (arrayDeque.isEmpty() == false){
            TreeNode node = arrayDeque.pop();
            System.out.print(node.value + " ");
            if (node.right != null){
                arrayDeque.push(node.right);
            }
            if (node.left != null){
                arrayDeque.push(node.left);
            }
        }
        System.out.println("\n");
    }
    /**
     * 广度优先遍历，非递归实现，辅助队列
     */
    public void levelOrderTraversal(){
        if (root == null){
            System.out.print("empty 树");
            return;
        }
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<TreeNode>();
        arrayDeque.add(root);
        while (arrayDeque.isEmpty() == false){
            TreeNode node = arrayDeque.remove();
            System.out.print(node.value + " ");
            if (node.left != null){
                arrayDeque.add(node.left);
            }
            if (node.right != null){
                arrayDeque.add(node.right);
            }
        }
        System.out.println("\n");
    }
    public static void main(String [] args){
        int [] arr = {0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
        TreeDepthWidth tree = new TreeDepthWidth(arr);
        tree.depthOrderTraversal();
        tree.levelOrderTraversal();
    }
}