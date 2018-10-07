package com.jack.algorithm.排序算法;

/**
 * @Author: Jack
 * @Date: 2018/10/7 20:59
 */
public class PrintSortedValue {
    public static final int a[] = {2,5,7,1,3,9,6,8,4};
    public void printValue(int []a) {
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }
}