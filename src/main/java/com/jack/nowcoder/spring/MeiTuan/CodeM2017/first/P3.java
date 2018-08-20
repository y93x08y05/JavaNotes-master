package com.jack.nowcoder.spring.MeiTuan.CodeM2017.first;

import java.util.Scanner;

/**
 * 输入。两个字符串A和B，合并成一个串C，属于A和B的字符在C中顺序保持不变。
 * 如"abc"和"xyz"可以被组合成"axbycz"或"abxcyz"等。
 * 定义字符串的价值为其最长回文子串的长度
 * （回文串表示从正反两边看完全一致的字符串，如"aba"和"xyyx"）
 * 需要求出所有可能的C中价值最大的字符串，输出这个最大价值即可
 * 输入描述
 * 第一行一个整数T（T<=50）
 * 接下来2T行，每两行两个字符串分别代表A和B，A和B的字符集为小写字母
 * 输出描述：
 * 对于每组数据输出一行一个整数表示价值最大的C的价值。
 * 输入
 * 2
 * aa
 * bb
 * a
 * aaaabcaa
 * 输出
 * 4
 * 5
 */
public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n>0) {
            String a = sc.next();
            String b = sc.next();
            int len1 = a.length();
            int len2 = b.length();
            int ans = 1;
            boolean [][][][] dp = new boolean[len1+2][len1+2][len2+2][len2+2];
            for (int l1 = 0;l1<=len1;l1++) {
                for (int l2 = 0;l2<=len2;l2++) {
                    for (int i=1,j=i+l1-1;j<=len1;j++,i++) {
                        for (int k=1,l=k+l2-1;l<=len2;l++,k++) {
                            if (l1+l2 <= 1) {
                                dp[i][j][k][l] = true;
                            } else {
                                dp[i][j][k][l] = false;
                                if (l1>1&&a.charAt(i-1)==a.charAt(j-1)) {
                                    dp[i][j][k][l] |= dp[i+1][j-1][k][l];
                                }
                                if (!dp[i][j][k][l]&&l2>1&&b.charAt(k-1)==b.charAt(l-1)) {
                                    dp[i][j][k][l] |= dp[i][j][k+1][l-1];
                                }
                                if (!dp[i][j][k][l]&&l1>0&&l2>0&&a.charAt(i-1)==b.charAt(l-1)) {
                                    dp[i][j][k][l] |= dp[i+1][j][k][l-1];
                                }
                                if (!dp[i][j][k][l]&&l1>0&&l2>0&&a.charAt(j-1)==b.charAt(k-1)) {
                                    dp[i][j][k][l] |= dp[i][j-1][k+1][l];
                                }
                            }
                            if (dp[i][j][k][l]) {
                                ans = Math.max(ans, j - i + l - k + 2);
                            }
                        }
                    }
                }
            }
            System.out.println(ans);
            n--;
        }
    }
}