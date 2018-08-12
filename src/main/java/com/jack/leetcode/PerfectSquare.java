package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 3:28 PM
 * LeetCode 367
 * give a positive number and justify if is a perfect number
 * if is return true else return false
 * 1+3+5+..+(2N-1) == N^2
 */
public class PerfectSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPerfectSquare(n));
    }
    private static boolean isPerfectSquare(int n) {
        for (int i=1;n>0;i+=2) {
            n-=i;
        }
        return 0==n;
    }
}
