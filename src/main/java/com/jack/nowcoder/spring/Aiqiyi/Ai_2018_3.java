package com.jack.nowcoder.spring.Aiqiyi;

import java.util.Scanner;

/**
 * 如果一个字符串S是由两个字符串T连接而成,即S = T + T, 我们就称S叫做平方串,
 * 例如"","aabaab","xxxx"都是平方串.
 * 牛牛现在有一个字符串s,请你帮助牛牛从s中移除尽量少的字符,让剩下的字符串是一个平方串。
 * 换句话说,就是找出s的最长子序列并且这个子序列构成一个平方串
 * 输入描述
 * 输入一个字符串s,字符串长度length(1 ≤ length ≤ 50),字符串只包括小写字符。
 * 输出描述
 * 输出一个正整数,即满足要求的平方串的长度。
 * 输入例子
 * frankfurt
 * 输出例子
 * 4
 */
public class Ai_2018_3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        int[][] dp = new int[n][n];
        int max = 0;
        for (int i = 1; i < str.length(); i++) {
            String str1 = str.substring(0,i);
            String str2 = str.substring(i);
            dp[0][0] = 0;
            //二维数组动态进行元素的赋值，构成子矩阵
            //即将一个字符串动态的拆分成两个字符串，并求其最长公共子串
            for (int j = 1; j <= i; j++) {
                dp[j][0] = 0;
            }
            for (int j = 1; j <= n-i; j++) {
                dp[0][j] = 0;
            }
            //把字符串动态拆分成两部分，然后对于前后两部分子串进行比较
            for (int p = 1; p <= i; p++) {
                for (int q = 1; q <= n-i ; q++) {
                    if(str1.charAt(p-1) == str2.charAt(q-1))
                        dp[p][q] = dp[p-1][q-1] + 1;
                    else
                        dp[p][q] = Math.max(dp[p-1][q],dp[p][q-1]);
                }
            }
            //每次分割字符串后将最长的子字符串长度更新
            if(dp[i][n-i] > max)
                max = dp[i][n-i];
        }
        //将最长的公共子序列乘以2即构成平方数的长度
        max = max * 2;
        System.out.println(max);
    }
}