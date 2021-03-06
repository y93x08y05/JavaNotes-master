package com.jack.algorithm.概览.树;

/**
 * 输入某二叉树的前序遍历和中序遍历，重建二叉树
 * 前序遍历和中序遍历的结果中都不含重复的数字
 * 重建二叉树并返回
 */
public class ConstructTree {
    class Node{
        int val;
        Node left = null;
        Node right = null;
        Node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        ConstructTree constructTree=new ConstructTree();
        int [] pre = {1,2,4,5,3,6,7};
        int [] in = {4,2,5,1,6,3,7};
        Node root = constructTree.reConstructTree(pre,in);
        constructTree.getVal(root);
    }
    private void getVal(Node root) {
        if (null==root) {
            return;
        }
        getVal(root.left);
        getVal(root.right);
        System.out.print(root.val+" ");
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
        //System.out.print(root.val+" ");//通过中序遍历找节点，按照先序遍历构建树
        for (int i=startIn;i<=endIn;i++) {
            if (in[i] == pre[startPre]) {
                root.left = reConstruct(pre,startPre+1,i-startIn+startPre,in,startIn,i-1);
                root.right = reConstruct(pre,startPre+(i-startIn)+1,endPre,in,i+1,endIn);
            }
        }
        return root;
    }
}