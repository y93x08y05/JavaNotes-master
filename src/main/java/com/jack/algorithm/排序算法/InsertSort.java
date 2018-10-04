package com.jack.algorithm.排序算法;

/**
 * Created by jack on 7/23/2018 9:46 PM
 * insert mergeSort stable
 */
public class InsertSort {
    public static void main(String[] args) {
        int a[] = {2,5,7,1,3,9,6,8,4};
        insertSort(a);
    }
    private static void insertSort(int []a) {
        int temp;
        for (int i=1;i<a.length;i++) {
            printValue(a);
            temp = a[i];
            int j = i - 1;
            for (;j>=0 && temp < a[j];--j) {
                a[j+1] = a[j];
            }
            a[j+1] = temp;
        }
    }
    private static void printValue(int []a) {
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }
    }
}