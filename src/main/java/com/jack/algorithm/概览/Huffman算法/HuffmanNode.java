package com.jack.algorithm.概览.Huffman算法;

/**
 * @Author: Jack
 * @Date: 2018/10/2 15:52
 */
public class HuffmanNode implements Comparable,Cloneable{
    protected int key;
    protected HuffmanNode left;
    protected HuffmanNode right;
    protected HuffmanNode parent;
    protected HuffmanNode(int key,HuffmanNode left,HuffmanNode right,HuffmanNode parent) {
        this.key=key;
        this.left=left;
        this.right=right;
        this.parent=parent;
    }

    @Override
    public int compareTo(Object o) {
        return this.key-((HuffmanNode)o).key;
    }

    @Override
    public Object clone() {
        Object obj=null;
        try {
            obj=super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}