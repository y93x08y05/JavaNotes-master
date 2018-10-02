package com.jack.algorithm.Huffman;

/**
 * @Author: Jack
 * @Date: 2018/10/2 21:40
 */
public class Huffman {
    private HuffmanNode root;
    public Huffman(int []a) {
        HuffmanNode parent=null;
        MinHeap heap;
        heap=new MinHeap(a);
        for (int i=0;i<a.length-1;i++) {
            HuffmanNode left=heap.dumpFromMinmum();
            HuffmanNode right=heap.dumpFromMinmum();
            parent=new HuffmanNode(left.key+right.key,left,right,null);
            left.parent=parent;
            right.parent=parent;
            heap.insert(parent);
        }
        root=parent;
        heap.destory();
    }
    private void preOrder(HuffmanNode tree) {
        if (tree!=null) {
            System.out.print(tree.key+" ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }
    public void preOrder() {
        preOrder(root);
    }
    private void inOrder(HuffmanNode tree) {
        if (tree!=null) {
            inOrder(tree.left);
            System.out.print(tree.key+" ");
            inOrder(tree.right);
        }
    }
    public void inOrder() {
        inOrder(root);
    }
    private void postOrder(HuffmanNode tree) {
        if (tree!=null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.println(tree.key+" ");
        }
    }
    public void postOrder() {
        postOrder(root);
    }
    private void destroy(HuffmanNode tree) {
        if (tree==null)
            return;
        if (tree.left!=null)
            destroy(tree.left);
        if (tree.right!=null)
            destroy(tree.right);
    }
    public void destroy() {
        destroy(root);
        root=null;
    }
    private void print(HuffmanNode tree,int key,int direction) {
        if (tree!=null) {
            if (direction==0) {
                System.out.printf("%2d is root\n",tree.key);
            } else {
                System.out.printf("%2d is %2d's %6s child\n",tree.key,key,direction==1?"right":"left");
            }
            print(tree.left,tree.key,-1);
            print(tree.right,tree.key,1);
        }
    }
    public void print() {
        if (root!=null)
            print(root,root.key,0);
    }
}