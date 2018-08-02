package com.jack.sort;

/**
 * Created by jack on 7/23/2018 9:29 PM
 * bubble sort stable
 */
public class BubbleSort {
    public static void main(String[] args) {
        int a[] = {2,5,7,1,3,9,6,8,4};
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
    }
}
