package com.jack.algorithm.tree;

/**
 * 输入某二叉树的前序遍历和中序遍历，重建二叉树
 * 前序遍历和中序遍历的结果中都不含重复的数字
 * 重建二叉树并返回
 */
public class Test14 {
    static class Node{
        int val;
        Node left = null;
        Node right = null;
        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int [] pre = {1,2,4,5,3,6,7};
        int [] in = {4,2,5,1,6,3,7};
        Node root = reConstructTree(pre,in);
        getVal(root);
    }
    public static void getVal(Node root) {
        if (null != root) {
            System.out.println(root.val);
        }
    }
    public static Node reConstructTree(int [] pre,int [] in) {
        Node root = reConstruct(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    private static Node reConstruct(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        Node root = new Node(pre[startPre]);
        System.out.println(root.val);//通过中序遍历找节点，按照先序遍历构建树
        for (int i=startIn;i<=endIn;i++) {
            if (in[i] == pre[startPre]) {
                root.left = reConstruct(pre,startPre+1,i-startIn+startPre,in,startIn,i-1);
                root.right = reConstruct(pre,startPre+(i-startIn)+1,endPre,in,i+1,endIn);
            }
        }
        return root;
    }
}