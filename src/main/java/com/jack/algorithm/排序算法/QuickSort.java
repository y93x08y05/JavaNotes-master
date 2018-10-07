package com.jack.algorithm.排序算法;

/**
 * Created by Jack on 7/23/2018 8:56 PM
 * 快速排序是不稳定的
 */
public class QuickSort {
    public static void main(String[] args) {
        new QuickSort().method(PrintSortedValue.a,0,PrintSortedValue.a.length-1);
    }
    public void method(int [] a, int low, int high) {
        if (low < high) {
            int mid = getMid(a,low,high);
            method(a,low,mid-1);
            method(a,mid+1,high);
        }
    }
    public int getMid(int [] a, int low, int high) {
        int temp = a[low];
        while (low < high) {
            while (low < high && a[high] >= temp) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= temp) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        new PrintSortedValue().printValue(a);
        return low;
    }
}
