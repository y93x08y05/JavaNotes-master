package com.jack.algorithm.Huffman;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jack
 * @Date: 2018/10/2 19:21
 */
public class MinHeap {
    private List<HuffmanNode> heap;
    protected MinHeap(int a[]) {
        heap=new ArrayList<>();
        for (int i=0;i<a.length;i++) {
            HuffmanNode node=new HuffmanNode(a[i],null,null,null);
            heap.add(node);
        }
        for (int i=a.length/2-1;i>=0;i--) {
            filterDown(i,a.length-1);
        }
    }
    protected void filterDown(int start,int end) {
        int c=start;
        int l=2*c+1;
        HuffmanNode tmp=heap.get(c);
        while (l<=end) {
            if (l<end&&(heap.get(l).compareTo(heap.get(l+1))>0))
                l++;
            int cmp=tmp.compareTo(heap.get(l));
            if (cmp<=0)
                break;
            else {
                heap.set(c,heap.get(l));
                c=l;
                l=2*l+1;
            }
        }
        heap.set(c,tmp);
    }
    protected void filterUp(int start) {
        int c=start;
        int p=(c-1)/2;
        HuffmanNode tmp=heap.get(c);
        while (c>0) {
            int cmp=heap.get(p).compareTo(tmp);
            if (cmp<=0)
                break;
            else {
                heap.set(c,heap.get(p));
                c=p;
                p=(p-1)/2;
            }
        }
        heap.set(c,tmp);
    }
    protected void insert(HuffmanNode node) {
        int size=heap.size();
        heap.add(node);
        filterUp(size);
    }
    protected void swapNode(int i,int j) {
        HuffmanNode tmp=heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,tmp);
    }
    protected HuffmanNode dumpFromMinmum() {
        int size=heap.size();
        if (size==0)
            return null;
        HuffmanNode node= (HuffmanNode) heap.get(0).clone();
        heap.set(0,heap.get(size-1));
        heap.remove(size-1);
        if (heap.size()>1)
            filterDown(0,heap.size()-1);
        return node;
    }
    protected void destory() {
        heap.clear();
        heap=null;
    }
}