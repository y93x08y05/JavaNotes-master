package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/6/2018 2:53 PM
 * LeetCode 342
 * input a number and judge is power of four or not
 */
public class PowerOfFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPowerOfFour(n));
    }
    private static boolean isPowerOfFour(int num) {
        while (num > 1) {
            if (num % 4 == 0 && (num % 10 == 4 || num % 10 == 6))
                num/=4;
            else
                return false;
        }
        if (num == 1)
            return true;
        return false;
    }
}
