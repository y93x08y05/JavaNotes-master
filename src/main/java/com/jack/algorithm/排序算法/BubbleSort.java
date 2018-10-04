package com.jack.algorithm.排序算法;

/**
 * Created by jack on 7/23/2018 9:29 PM
 * bubble mergeSort stable
 */
public class BubbleSort {
    public static void main(String[] args) {
        int a[] = {2,5,7,1,3,9,6,8,4};
        sort1(a);
        sort2(a);
    }
    private static void sort1(int []a) {
        int temp;
        for (int i=0;i<a.length;i++) {
            for (int j=0;j<a.length-1-i;j++) {
                if (a[j] > a[j+1]) {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    private static void sort2(int []a) {
        int temp;
        for (int i=0;i<a.length-1;i++) {
            for (int j=i+1;j<a.length;j++) {
                if (a[i] > a[j]) {
                    temp = a[j];
                    a[j] = a[i];
                    a[j] = temp;
                }
            }
        }
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }
    }
}
