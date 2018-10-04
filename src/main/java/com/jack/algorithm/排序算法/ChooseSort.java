package com.jack.algorithm.排序算法;

/**
 * Created by jack on 7/23/2018 9:37 PM
 * choose mergeSort not stable
 */
public class ChooseSort {
    public static void main(String[] args) {
        int a[] = {2,5,7,1,3,9,6,8,4};
        chooseSort(a);
    }
    private static void chooseSort(int []a) {
        int position;
        for (int i=0;i<a.length;i++) {
            printValue(a);
            position = i;
            int temp = a[i];
            for (int j=i+1;j<a.length;j++) {
                if (a[j] < temp) {
                    temp = a[j];
                    position = j;
                }
            }
            a[position] = a[i];
            a[i] = temp;
        }
    }
    private static void printValue(int []a) {
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }
}
