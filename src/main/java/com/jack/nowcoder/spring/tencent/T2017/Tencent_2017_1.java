package com.jack.nowcoder.spring.tencent.T2017;

import java.util.Scanner;

/**
 * Created by zhangta on 1/10/2018.
 * 给定字符串s，从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
 * 输出需要删除的字符个数，即求两个字符串之间的最长公共子串
 * 输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
 * 对于每组数据，输出一个整数，代表最少需要删除的字符个数。
 * 输入例子
 * abcda
 * google
 * 输出例子
 * 2
 * 2
 */
public class Tencent_2017_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.next();
            System.out.println(s1);
            String s2 = new StringBuilder(s1).reverse().toString();
            System.out.println(s2);
            //Needleman/Wunsch算法，动态规划思想，构建矩阵
            int[][] dp = new int[s1.length() + 1][s2.length() + 1];
            for (int i = 1; i < dp.length; i ++ ) {
                for (int j = 1; j < dp[0].length; j ++ ) {
                    dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
            System.out.println(s1.length() - dp[s1.length()][s2.length()]);
        }
    }
}
