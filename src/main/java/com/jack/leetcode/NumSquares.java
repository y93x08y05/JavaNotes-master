package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/11 18:38
 * LeetCode 279
 * 完全平方数
 * 给定正整数 n，
 * 找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 * 例1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 例2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class NumSquares {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(numSquare(n));
    }
    private static int numSquare(int n) {
        List<Integer> square = new ArrayList<>();
        for(int i=1;i*i<=n;i++) {
            square.add(i*i);
        }
        int [] dp = new int[n+1];
        for(int i=1;i<=n;i++) {
            dp[i] = i;
            for(int num=0;num<square.size();num++) {
                if (square.get(num) > i) {
                    break;
                }
                dp[i] = Math.min(dp[i],1+dp[i-square.get(num)]);
            }
        }
        return dp[n];
    }
}