package com.jack.algorithm.排序算法;

/**
 * Created by Jack on 7/23/2018 9:46 PM
 * 插入排序是稳定的
 */
public class InsertSort {
    public static void main(String[] args) {
        new InsertSort().method(PrintSortedValue.a);
    }
    public void method(int []a) {
        int temp;
        for (int i=1;i<a.length;i++) {
            new PrintSortedValue().printValue(a);
            temp = a[i];
            int j = i - 1;
            for (;j>=0 && temp < a[j];--j) {
                a[j+1] = a[j];
            }
            a[j+1] = temp;
        }
        new PrintSortedValue().printValue(a);
    }
}