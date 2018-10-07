package com.jack.algorithm.排序算法;

/**
 * Created by Jack on 7/23/2018 9:37 PM
 * 选择排序是不稳定的
 */
public class ChooseSort {
    public static void main(String[] args) {
        new ChooseSort().method(PrintSortedValue.a);
    }
    public void method(int []a) {
        int position;
        for (int i=0;i<a.length;i++) {
            new PrintSortedValue().printValue(a);
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
        new PrintSortedValue().printValue(a);
    }
}
