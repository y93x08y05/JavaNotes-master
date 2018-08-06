package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/6/2018 2:35 PM
 * LeetCode 326
 * input a number and judge is power of three or not
 */
public class PowerOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPowerOfThree(n));
    }
    private static boolean isPowerOfThree(int n) {
        while (n > 1) {
            if (n % 3 == 0 && (n % 10 == 1 || n % 10 == 3 || n % 10 == 7 || n % 10 == 9))
                n/=3;
            else
                return false;
        }
        if (n == 1)
            return true;
        return false;
    }
}
