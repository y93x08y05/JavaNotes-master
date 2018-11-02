package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/11 18:35
 * LeetCode 264
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * 例：
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 */
public class NthUglyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findUglyNumber(n));
    }
    private static int findUglyNumber(int n) {
        if(n <= 0) {
            return 0;
        }
        int[] result = new int [n];
        int count = 0;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        result[0] = 1;
        int temp;
        while(count < n-1) {
            temp = Math.min(result[i2] * 2, Math.min(result[i3] * 3, result[i5] * 5));
            if(temp == result[i2] * 2) i2++;
            if(temp == result[i3] * 3) i3++;
            if(temp == result[i5] * 5) i5++;
            result[++count] = temp;
        }
        return result[n - 1];
    }
}
