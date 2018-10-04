package com.jack.剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jack on 8/1/2018 1:48 PM
 * 打印二叉树中的节点值的和为输入值的所有路径
 */
public class Main24 {
    private static int [] arr = {1,2,4,3,8,6,7,5,9};
    private static int target = 11;
    private static List<Node> list = null;
    private static List<List<Integer>> lists = new ArrayList<>();
    private static List<Integer> list1 = new ArrayList<>();
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
        List<List<Integer>> lists1 = findPath(node,target);
        for (int i=0;i<lists1.size();i++) {
            for (int j=0;j<lists1.get(i).size();j++) {
                System.out.print(lists1.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    private static List<List<Integer>> findPath(Node node,int target) {
        if (node == null)
            return lists;
        list1.add(node.data);
        target = target - node.data;
        if (target == 0 && node.left == null && node.right == null) {
            lists.add(new ArrayList<>(list1));
        }
        findPath(node.left,target);
        findPath(node.right,target);
        list1.remove(list1.size()-1);
        return lists;
    }
    private static void createBinaryTree(int [] arr) {
        list = new LinkedList<>();
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
