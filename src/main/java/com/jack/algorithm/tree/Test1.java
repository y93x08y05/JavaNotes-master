package com.jack.algorithm.tree;

/**
 * 用有序数组生成一颗平衡搜索二叉树
 * 即利用二分法进行递归实现
 * 平衡二叉树的左右子树高度差为1
 */
public class Test1 {
    class Node{
        int value;
        Node left = null;
        Node right = null;
        Node(int value) {
            this.value = value;
        }
    }
    public Node sortedArrayToBST(int [] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        return helper(num,0,num.length-1);
    }
    public Node helper(int [] num,int left,int right) {
        if (left <= right) {
            int mid = left + (right - left)/2;
            Node node = new Node(num[mid]);
            node.left = helper(num,left,mid-1);
            node.right = helper(num,mid+1,right);
            return node;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        Test1 test1 = new Test1();
        test1.sortedArrayToBST(arr);
    }
}