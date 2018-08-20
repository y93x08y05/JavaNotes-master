package com.jack.nowcoder.spring.A163.SpringJava0617;

/**
 * 未能在规定时间内运行结束，时间复杂度过大
 * 一个正整数数对(x, y)，x和y均不大于n, 并且x除以y的余数大于等于k。
 * 计算一共有多少个可能的数对。
 * 输入描述
 * 输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。
 * 输出描述
 * 对于每个测试用例, 输出一个正整数表示可能的数对数量。
 * 输入例子
 * 5 2
 * 输出例子
 * 7
 */

import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int max = 0;
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                if (i %j >= k) {
                    max++;
                }
            }
        }
        System.out.println(max);
    }
}