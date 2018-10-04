package com.jack.algorithm.排序算法;

/**
 * Created by jack on 7/23/2018 8:56 PM
 * quick mergeSort not stable
 */
public class QuickSort {
    public static void main(String[] args) {
        int a[] = {5,9,4,2,1,8,3,6,7};
        quickSort(a,0,a.length-1);
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }
    }
    public static void quickSort(int [] list,int low,int high) {
        if (low < high) {
            int middle = getMiddle(list,low,high);
            quickSort(list,low,middle-1);
            quickSort(list,middle+1,high);
        }
    }
    public static int getMiddle(int [] list,int low,int high) {
        int temp = list[low];
        while (low < high) {
            while (low < high && list[high] >= temp) {
                high--;
            }
            list[low] = list[high];
            while (low < high && list[low] <= temp) {
                low++;
            }
            list[high] = list[low];
        }
        list[low] = temp;
        return low;
    }
}
