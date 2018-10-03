package com.jack.algorithm.概览.Huffman算法;

/**
 * @Author: Jack
 * @Date: 2018/10/2 22:06
 */
public class HuffmanTest {
    private static final int a[]={5,6,8,7,15};

    public static void main(String[] args) {
        int i;
        Huffman tree;
        System.out.print("== 添加数组：");
        for (i=0;i<a.length;i++) {
            System.out.print(a[i]+" ");
        }
        tree=new Huffman(a);
        System.out.print("\n前序遍历：");
        tree.preOrder();
        System.out.print("\n中序遍历：");
        tree.inOrder();
        System.out.print("\n后序遍历：");
        tree.postOrder();
        System.out.println();
        System.out.println("== 树的详细信息：");
        tree.print();
        tree.destroy();
    }
}