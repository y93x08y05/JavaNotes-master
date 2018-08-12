package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 3:48 PM
 * LeetCode 633
 * give a number named c and check if have a and b let a^2+b^2=c
 * if have return true else return false
 */
public class SquareSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(ifSquareSum(n));
    }
    private static boolean ifSquareSum(int n) {
        int half = n>>1;
        int sb,b;
        for (int i=0;i*i<=half;++i) {
            sb=n-i*i;
            b=(int)Math.sqrt(sb);
            if (b*b==sb)
                return true;
        }
        return false;
    }
}
