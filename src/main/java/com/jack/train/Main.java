package com.jack.train;

/**
 * Created by Jack on 7/28/2018 9:12 PM
 */
public class Main {
    public static void main(String[] args) {
        int a [] = {1,2};
        int b [] = {3,4};
        System.out.println(getResult(a, b));
    }
    public static double getResult(int [] a,int [] b) {
        int m = 0;
        int n = 0;
        int k = (a.length + b.length) / 2;
        int sum = 0;
        while (m < a.length && n < b.length) {
            sum = a[m] < b[n] ? a[m++] : b[n++];
            k--;
        }
        while (m < a.length && k >= 0) {
            sum = a[m++];
            k--;
        }
        while (n < b.length && k >= 0) {
            sum = b[n++];
            k--;
        }
        return sum;
    }
}
