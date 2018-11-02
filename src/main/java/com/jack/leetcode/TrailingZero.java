package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/5 15:44
 * LeetCode 172
 * 给定一个数，返回N的阶乘结果中零的数量。
 * 例1：
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 例2
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 */
public class TrailingZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findZeroCount(n));
    }

    /**
     * 分解因子，当且出现一对2和5时，末尾添加一个0，因子2多于因子5，
     * 计算n的因子中包含多少个5
     * @param n
     * @return
     */
    private static int findZeroCount(int n) {
        if (n <= 0)
            return 0;
        int count = 0;
        while (n / 5 != 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}