package com.jack.algorithm.sort;

/**
 * Created by jack on 7/23/2018 9:51 PM
 * merge mergeSort stable
 */
public class mergeSort {
    public static void main(String[] args) {
        int a[] = {2,5,7,1,3,9,6,8,4};
        sort(a,0,a.length-1);
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }
    }
    public static void sort(int [] data,int left,int right) {
        if (left < right) {
            int center = (left + right) / 2;
            sort(data,left,center);
            sort(data,center+1,right);
            merge(data,left,center,right);
        }
    }
    public static void merge(int [] data,int left,int center,int right) {
        int [] tempArr = new int[data.length];
        int middle = center + 1;
        int third = left;
        int temp = left;
        while (left <= center && middle <= right) {
            if (data[left] <= data[middle]) {
                tempArr[third++] = data[left++];
            } else {
                tempArr[third++] = data[middle++];
            }
        }
        while (middle <= right) {
            tempArr[third++] = data[middle++];
        }
        while (left <= center) {
            tempArr[third++] = data[left++];
        }
        while (temp <= right) {
            data[temp] = tempArr[temp++];
        }
    }
}
