package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/11 17:57
 * LeetCode 204
 * 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * 例：
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class CountPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countPrimes(n));
    }
    private static int countPrimes(int n) {
        if(n <= 1) {
            return 0;
        }
        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;
        for(int i = 2; i * i < n; i++) {
            if(!notPrime[i]) {
                for(int j = 2 * i; j < n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        int result = 0;
        for(int i = 0; i < notPrime.length; i++) {
            if(!notPrime[i]) {
                result++;
            }
        }
        return result;
    }
}