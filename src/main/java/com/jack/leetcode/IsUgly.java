package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/11 18:32
 * LeetCode 263
 * 编写一个程序判断给定的数是否为丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * 例1:
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 * 例2:
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 × 2
 * 例3:
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 */
public class IsUgly {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isUgly(n));
    }
    private static boolean isUgly(int num) {
        if(num < 1) {
            return false;
        } else {
            while(true) {
                if(num == 1) {
                    return true;
                } else if(num == -1) {
                    return false;
                } else {
                    if(num % 2 == 0) {
                        num = num / 2;
                    } else if(num % 3 == 0) {
                        num = num / 3;
                    } else if(num % 5 == 0) {
                        num = num / 5;
                    } else {
                        num = -1;
                    }
                }
            }
        }
    }
}