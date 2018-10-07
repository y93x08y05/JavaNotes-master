package com.jack.algorithm.排序算法;

/**
 * Created by Jack on 7/23/2018 9:29 PM
 * 冒泡排序是稳定的
 */
public class BubbleSort {
    public static void main(String[] args) {
        new BubbleSort().method1(PrintSortedValue.a);
        new BubbleSort().method2(PrintSortedValue.a);
    }
    public void method1(int []a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j+1]) {
                    a[j] = a[j] + a[j+1];
                    a[j+1] = a[j] - a[j+1];
                    a[j] = a[j] - a[j+1];
                }
            }
        }
        new PrintSortedValue().printValue(a);
    }
    public void method2(int []a) {
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    a[i] = a[i] + a[j];
                    a[j] = a[i] - a[j];
                    a[i] = a[i] - a[j];
                }
            }
        }
        new PrintSortedValue().printValue(a);
    }
}
