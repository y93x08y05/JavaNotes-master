package com.jack.algorithm.tree;

/**
 * 输入一棵二叉树，判断是否是平衡二叉树
 * 平衡二叉树的高度之差不超过1
 */
public class Test13 {
    static class Node{
        int val;
        Node left = null;
        Node right = null;
        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7};
        Node root = createTree(arr,0,arr.length-1);
        System.out.println(isBalance(root));

        int [] pre = {1,2,4,6,7,5,3};
        int [] in = {6,4,7,2,5,1,3};
        Node root1 = reConstructTree(pre,in);
        System.out.println(isBalance(root1));

    }
    public static Node createTree(int [] a , int left , int right) {
        if (left > right) {
            return null;
        }
        Node node = new Node(a[(left + right) / 2]);
        node.val = a[(left + right) / 2];
        node.left = createTree(a,left,(left + right)/2-1);
        node.right = createTree(a,(left+right)/2+1,right);
        return node;
    }
    public static boolean isBalance(Node root) {
        if (root == null) {
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return true;
    }
    public static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return (leftHeight > rightHeight) ? (leftHeight+1):(rightHeight+1);
    }

    //构建一个非平衡二叉树
    public static Node reConstructTree(int [] pre,int [] in) {
        Node root = reConstruct(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    private static Node reConstruct(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        Node root = new Node(pre[startPre]);
        for (int i=startIn;i<=endIn;i++) {
            if (in[i] == pre[startPre]) {
                root.left = reConstruct(pre,startPre+1,i-startIn+startPre,in,startIn,i-1);
                root.right = reConstruct(pre,startPre+(i-startIn)+1,endPre,in,i+1,endIn);
            }
        }
        return root;
    }
}