package com.jack.algorithm.tree;

import java.util.ArrayList;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径
 * 路径定义为从树的根结点开始往下一直到叶节点所经过的节点行程一条路径
 */
public class Test11 {
    static class Node{
        int value;
        Node left = null;
        Node right = null;
        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,1,4};
        int m = 9;
        Node root = createTree(arr,0,arr.length-1);
        ArrayList<ArrayList<Integer>> arrayLists = findPath(root,m);
        for (int i=0;i<arrayLists.size();i++) {
            for (int j=0;j<arrayLists.get(i).size();j++) {
                System.out.print(arrayLists.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static Node createTree(int [] a , int left , int right) {
        if (left > right) {
            return null;
        }
        Node node = new Node(a[(left + right) / 2]);
        node.value = a[(left + right) / 2];
        node.left = createTree(a,left,(left + right)/2-1);
        node.right = createTree(a,(left+right)/2+1,right);
        return node;
    }

    public static ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<Integer> list = new ArrayList<Integer>();
    public static ArrayList<ArrayList<Integer>> findPath(Node root,int target) {
        if (root == null) {
            return listAll;
        }
        list.add(root.value);
        target = target - root.value;
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<Integer>(list));
        }
        findPath(root.left,target);
        findPath(root.right,target);
        list.remove(list.size()-1);
        return listAll;
    }
}