package com.jack.algorithm.排序算法;

/**
 * Created by jack on 7/23/2018 10:03 PM
 * heap mergeSort not stable
 */
public class heapSort {
    public static void main(String[] args) {
        int a[] = {2,5,7,1,3,9,6,8,4};
        int n = a.length;
        int temp;
        initGreatestHeap(a,n);
        for (int i=n-1;i>0;i--) {
            temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            greatestHeap(a,i,0);
        }
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }

    }
    public static void initGreatestHeap(int a[],int n) {
        for (int i=(n-1)/2;i>=0;i--) {
            greatestHeap(a,n,i);
        }
    }
    public static void greatestHeap(int a[] , int n ,int h) {
        int i,j,flag;
        int temp;
        i = h;
        j = 2*i+1;
        flag = 0;
        temp = a[i];
        while (j < n && flag != 1) {
            if (j < n-1 && a[j] < a[j+1]) {
                j++;
            }
            if (temp > a[j]) {
                flag = 1;
            } else {
                a[i] = a[j];
                i = j;
                j = 2*i+1;
            }
        }
        a[i] = temp;
    }
}
