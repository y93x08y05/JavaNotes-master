package com.jack.algorithm.classicAlgorithm;

/**
 * 手写两个有序数组，找第k大数
 */
public class FindKthInArray {
    public static void main(String [] args){
        int k = 10;
        int a [] = {1,2,3,4,5};
        int b [] = {2,4,5,8,10,22};
        System.out.println(FindKthInUnion(a, b, k));
    }
    public static int FindKthInUnion(int a [] ,int b [] ,int k){
        if (k == 0){
            return Math.min(a[0],b[0]);
        }
        int la = Math.min(a.length-1,k);
        int lb = Math.min(b.length-1,k);
        int i = (k * a.length)/(a.length + b.length);
        int j = k-i-1;
        for (;;){
            if (a[i] < b[j]){
                if (i == la || a[i+1] > b[j]){
                    return b[j];
                } else {
                    i += (la - i + 1)/2;
                    j = k - i -1;
                }
            } else {
                if (j == lb || b[j+1] > a[i]) {
                    return a[i];
                } else {
                    j += (lb - j + 1)/2;
                    i = k-i-1;
                }
            }
        }
    }
}