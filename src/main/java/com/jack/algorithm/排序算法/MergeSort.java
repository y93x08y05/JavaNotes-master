package com.jack.algorithm.排序算法;

/**
 * Created by Jack on 7/23/2018 9:51 PM
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        new MergeSort().method(PrintSortedValue.a,0,PrintSortedValue.a.length-1);
    }
    public void method(int [] a, int low, int high) {
        if (low < high) {
            int center = (low + high) / 2;
            method(a,low,center);
            method(a,center+1,high);
            merge(a,low,center,high);
        }
    }
    public void merge(int [] a,int low,int center,int high) {
        System.out.println("low="+low+" center="+center+" high="+high);
        int [] tempArr = new int[a.length];
        int mid = center + 1;
        int third = low;
        int temp = low;
        /*
        * 即左右部分已经分别有序，让其保持整体有序
        * 当mid之前的元素有大于mid时，会将mid放入
        * 临时数组，并且mid++再做判断
        * 直到low大于center或者mid大于high
        * 然后执行下边的while语句，将剩下的值
        * 放入临时数组中
        */
        while (low <= center && mid <= high) {
            if (a[low] <= a[mid]) {
                tempArr[third++] = a[low++];
            } else {
                tempArr[third++] = a[mid++];
            }
        }
        /*即mid后边的元素大于mid前边的元素*/
        while (mid <= high) {
            tempArr[third++] = a[mid++];
        }
        /*即center后边的元素小于center前边的元素*/
        while (low <= center) {
            tempArr[third++] = a[low++];
        }
        /*即将归并之后的数组值再复制到原数组中*/
        while (temp <= high) {
            a[temp] = tempArr[temp++];
        }
        new PrintSortedValue().printValue(a);
    }
}
