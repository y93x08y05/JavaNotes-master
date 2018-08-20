package com.jack.basic.Other1;

import java.util.LinkedList;
import java.util.List;

/**
 * 数组值存储于二叉树，并进行先序、中序、后序遍历，即根节点的输出是最先还是中间输出或者最后输出
 * 从上到下分别为2,0次方，1次方，2次方个节点，从上到下第n层有2的（n-1）次方个节点
 * ArrayList以及LinkedList区别
 *   1. ArrayList是实现了基于动态数组的数据结构，而LinkedList是基于链表的数据结构；
 *   2. 对于随机访问get和set，ArrayList要优于LinkedList，因为LinkedList要移动指针；
 *   3. 对于添加和删除操作add和remove，LinkedList更加方便
 */
public class treeBinary {
    private int[] array = {1,2,3,4,5,6,7,8,9};
    private static List<Node> nodeList = null;
    private static class Node{
        Node leftChild;
        Node rightChild;
        int data;
        Node(int newData){
            leftChild = null;
            rightChild = null;
            data = newData;
        }
    }
    public  void  createBinaryTree(){
        nodeList = new LinkedList<Node>();
        for (int nodeIndex = 0;nodeIndex<array.length;nodeIndex++){
            nodeList.add(new Node(array[nodeIndex]));
        }
        System.out.println(nodeList);
        for (int parentIndex = 0;parentIndex < array.length / 2 - 1;parentIndex++){
            nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);
            nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);
        }
        /**
         *  parentIndex<array.length/2-1   parentIndex*2+2；
         * 即 nodeList中存放的个数应该小于parentIndex<array.length；
         * 最后一个父节点只有数组长度为奇数才有右孩子，否则只有左孩子；
         * 所以肯定可以得到左孩子，然后对于数组长度判断再做处理；
         * 一共会有array.length/2-1个父节点；
         * */
        int lastParentIndex = array.length / 2 - 1;
        nodeList.get(lastParentIndex).leftChild = nodeList.get(lastParentIndex*2+1);
        if(array.length % 2 == 1){
            nodeList.get(lastParentIndex).rightChild = nodeList.get(lastParentIndex*2+2);
        }
    }
        /**
         * 先序遍历
         */
        public static void preOrderTraverse(Node node) {
            if (node == null)
                return;
            System.out.print(node.data + " ");
            preOrderTraverse(node.leftChild);
            preOrderTraverse(node.rightChild);
        }
        /**
         * 中序遍历
         */
        public static void inOrderTraverse(Node node) {
            if (node == null)
                return;
            inOrderTraverse(node.leftChild);
            System.out.print(node.data + " ");
            inOrderTraverse(node.rightChild);
        }
        /**
         * 后序遍历
         */
        public static void postOrderTraverse(Node node) {
            if (node == null)
                return;
            postOrderTraverse(node.leftChild);
            postOrderTraverse(node.rightChild);
            System.out.print(node.data + " ");
        }
        //主函数
        public static void main(String[] args) {
            treeBinary binaryTree = new treeBinary();
            binaryTree.createBinaryTree();
            // nodeList中第0个索引处的值即为根节点
            Node root = nodeList.get(0);
            System.out.println("先序遍历：");
            preOrderTraverse(root);
            System.out.println();
            System.out.println("中序遍历：");
            inOrderTraverse(root);
            System.out.println();
            System.out.println("后序遍历：");
            postOrderTraverse(root);
        }
}
