package com.jack.nowcoder.spring.MeiTuan.CodeM2017.fouth;

import java.util.Scanner;

/**
 * 给定四个正整数a,b,c,k,回答是否存在一个正整数，使得a*n在k
 * 进制表示下的各位的数值之和模b为c。
 * 输入描述：
 * 第一行一个整数T(T<=5000)
 * 接下来T行，每行四个正整数a,b,c,k
 * (1 ≤ a ≤ 10^18; 2 ≤ k ≤ 10^18; 0 ≤ c < b ≤ 10^18)
 * 表示一个询问，所有输入都是十进制的。
 * 输出描述：
 * 对于每组数据输出一行，Yes表示存在，No表示不存在。
 * 输入
 * 2
 * 3 9 5 10
 * 7 3 1 10
 * 输出
 * No
 * Yes
 */
public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            long k = sc.nextLong();
            if(c%gcd(gcd(a,k-1),b)!=0) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
    public static long gcd(long a,long b) {
        long tmp;
        while(b > 0) {
            tmp=a%b;
            a=b;
            b=tmp;
        }
        return a;
    }
}