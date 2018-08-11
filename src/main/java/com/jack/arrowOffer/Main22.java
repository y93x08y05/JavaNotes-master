package com.jack.arrowOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Jack on 8/1/2018 10:06 AM
 * Print out every node of binary tree from top to bottom.
 * The same layer node print from left to right
 */
public class Main22 {
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
    public static void main(String[] args) {
        createBinaryTree(arr);
        Node node = list.get(0);
        List<Integer> list2 = printNode(node);
        for (int i=0;i<list2.size();i++) {
            System.out.print(list2.get(i) + " ");
        }
    }
    private static ArrayList<Integer> printNode(Node node) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        if (node == null)
            return list1;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node node1 = queue.poll();
            list1.add(node1.data);
            if (node1.left != null)
                queue.add(node1.left);
            if (node1.right != null)
                queue.add(node1.right);
        }
        return list1;
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
}
