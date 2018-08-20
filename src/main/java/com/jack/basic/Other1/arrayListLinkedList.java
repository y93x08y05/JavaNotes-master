package com.jack.basic.Other1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by zhangta on 1/30/2018.
 * 当插入的数据量很小时，两者区别不太大，当插入的数据量大时，大约在容量的1/10之前，
 * LinkedList会优于ArrayList，在其后就劣与ArrayList，且越靠近后面越差。
 * 一般首选用ArrayList，由于LinkedList可以实现栈、队列以及双端队列等数据结构，
 * 所以当特定需要时候，使用LinkedList，数据量小的时候，两者差不多，视具体情况去选择使用；
 * 当数据量大的时候，如果只需要在靠前的部分插入或删除数据，那也可以选用LinkedList，
 * 反之选择ArrayList反而效率更高。
 * 当数据量较大时，大约在容量的1/10处开始，LinkedList的效率就开始没有ArrayList效率高了，
 * 特别到一半以及后半的位置插入时，LinkedList效率明显要低于ArrayList，而且数据量越大，越明显
 *  ArrayList想要在指定位置插入或删除元素时，主要耗时的是System.arraycopy动作，会移动index后面所有的元素；
 *  LinkedList主耗时的是要先通过for循环找到index，然后直接插入或删除
 *  ArrayList想要get(int index)元素时，直接返回index位置上的元素，
 *  而LinkedList需要通过for循环进行查找
 */
public class arrayListLinkedList {
    static List<Integer> array=new ArrayList<Integer>();
    static List<Integer> linked=new LinkedList<Integer>();

    public static void main(String[] args) {

        //首先分别给两者插入10000条数据
        for(int i=0;i<10000;i++){
            array.add(i);
            linked.add(i);
        }
        //获得两者随机访问的时间
        System.out.println("array time:"+getTime(array));
        System.out.println("linked time:"+getTime(linked));
        //获得两者插入数据的时间
        System.out.println("array insert time:"+insertTime(array));
        System.out.println("linked insert time:"+insertTime(linked));

    }
    public static long getTime(List<Integer> list){
        long time=System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            int index = Collections.binarySearch(list, list.get(i));
            if(index != i){
                System.out.println("ERROR!");
            }
        }
        return System.currentTimeMillis()-time;
    }

    //插入数据
    public static long insertTime(List<Integer> list){
        /*
         * 插入的数据量和插入的位置是决定两者性能的主要方面，
         * 我们可以通过修改这两个数据，来测试两者的性能
         */
        long num = 10000; //表示要插入的数据量
        int index = 1000; //表示从哪个位置插入
        long time=System.currentTimeMillis();
        for(int i = 1; i < num; i++){
            list.add(index, i);
        }
        return System.currentTimeMillis()-time;

    }
}
