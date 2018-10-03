package com.jack.algorithm.经典算法;

/**
 * LRU算法，Last Recently Used
 * 选择最后一次访问时间距离当前时间最长的一页并淘汰
 * 即淘汰最长时间没有使用的页
 * 按最多五块的内存分配
 */
public class LRU {
    private int array [] ;
    private int back ;//定义队尾
    private int currentSize ;//队列中存放元素个数
    private int maxSize = 5;
    public LRU(){
        array = new int[maxSize];
        back = 0;
        currentSize = 0;
    }
    public void queue(int a [] ){
        for (int i=0;i<a.length;i++){
            enQuene(a[i]);
        }
    }
    public void enQuene(int x ){
        beUsed(x);//入队判断是否存在该页号，存在则删除
        if (currentSize < maxSize){
            array[back] = x;
            back++;
            currentSize++;
        } else if (currentSize == maxSize){
            for (int i = 0;i<maxSize-1;i++){
                array[i] = array[i+1];
            }
            array[maxSize-1] = x;
        }
        for (int i=0;i<currentSize;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public void beUsed(int x){
        for (int i=0;i<currentSize;i++){
            if (array[i] == x){
                for (int j=i;j<currentSize-1;j++){
                    array[j] = array[j+1];
                }
                currentSize--;
                back--;
            }
        }
    }
    public static void main(String [] args){
        LRU lru = new LRU();
        int a [] = {4,7,0,7,1,0,1,2,1,2,6};
        lru.queue(a);
    }
}