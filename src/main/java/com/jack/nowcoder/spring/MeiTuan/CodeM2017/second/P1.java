package com.jack.nowcoder.spring.MeiTuan.CodeM2017.second;

import java.util.Scanner;

/**
 * 给定两个整数l和r，对于所有满足1<=l<=x<=r<=10^9的x，把x的所有约数
 * 写出来，对于每个写下来的数，只保留最高位的数码，并统计1-9每个数码
 * 出现的次数。
 * 输入描述：
 * 一行，两个整数l和r。
 * 输出9行，第i行输出数码i出现的次数。
 * 例：输入
 * 1 4
 * 输出
 * 4
 * 2
 * 1
 * 1
 * 0
 * 0
 * 0
 * 0
 * 0
 */
public class P1 {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long [] arrA = new long[10];
        long [] arrB = new long[10];
        compute(arrA,a-1);
        compute(arrB,b);
        for (int i=1;i<10;i++) {
            System.out.println(arrB[i]-arrA[i]);
        }
    }
    public static void compute(long [] arr, long r) {
        for (int i=1;i<=9;i++) {
            for (long j=1;i*j<=r;j*=10) {
                long start = i*j;
                long end = Math.min((i+1)*j-1,r);
                long split;
                for (long k=start;k<=end;k+=split) {
                    long mul = r/k;
                    long re = r - mul*k;
                    split = 1;
                    split += Math.min(re/mul,end-k);
                    arr[i] += mul*split;
                }
            }
        }
    }
}