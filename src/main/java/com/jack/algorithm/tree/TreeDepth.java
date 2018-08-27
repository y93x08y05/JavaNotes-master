package com.jack.algorithm.tree;

/**
 * 输入一棵二叉树，求树的深度
 * 从根节点到叶节点经过的节点形成树的一条路径
 * 最长路径为树的深度
 */
public class TreeDepth {
    class Node{
        int val;
        Node left = null;
        Node right = null;
        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeDepth treeDepth=new TreeDepth();
        int [] arr = {1,2,3,4,5,6,7};
        Node root = treeDepth.createTree(arr,0,arr.length-1);
        System.out.println(treeDepth.findTreeDepth(root));
        int [] pre = {1,2,4,6,7,5,3};
        int [] in = {6,4,7,2,5,1,3};
        Node root1 = treeDepth.reConstructTree(pre,in);
        System.out.println(treeDepth.findTreeDepth(root1));
    }
    private int findTreeDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = findTreeDepth(root.left);
        int rightDepth = findTreeDepth(root.right);
        return (leftDepth > rightDepth)?(leftDepth+1):(rightDepth+1);
    }

    private Node createTree(int [] a , int left , int right) {
        if (left > right) {
            return null;
        }
        Node node = new Node(a[(left + right) / 2]);
        node.val = a[(left + right) / 2];
        node.left = createTree(a,left,(left + right)/2-1);
        node.right = createTree(a,(left+right)/2+1,right);
        return node;
    }

    private Node reConstructTree(int [] pre,int [] in) {
        Node root = reConstruct(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    private Node reConstruct(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
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