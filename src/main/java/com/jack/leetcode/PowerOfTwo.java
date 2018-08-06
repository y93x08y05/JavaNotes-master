package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/6/2018 2:13 PM
 * LeetCode 231
 * give a number and judge is power of 2 or not
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPowerOfTwo(n));
    }
    private static boolean isPowerOfTwo(int n) {
        while (n > 1) {
            if (n % 2 == 1)
                return false;
            n = n / 2;
        }
        if ( n == 1)
            return true;
        return false;
    }
}
