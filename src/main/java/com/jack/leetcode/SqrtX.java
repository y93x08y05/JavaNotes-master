package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 3:18 PM
 * LeetCode 69
 * give x and return sqrt(x) return int value if float keep int
 */
public class SqrtX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(findSqrt(x));
    }
    private static int findSqrt(int x) {
        return Integer.valueOf(String.valueOf(Math.sqrt(x)).substring(0,String.valueOf(Math.sqrt(x)).indexOf(".")));
    }
}
