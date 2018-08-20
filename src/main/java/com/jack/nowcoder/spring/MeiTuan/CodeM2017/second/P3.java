package com.jack.nowcoder.spring.MeiTuan.CodeM2017.second;

import java.util.Scanner;

/**
 * 组委会正在为美团点评CodeM大赛的决赛设计新赛制
 * 比赛有n个人参加，n为2的幂，每个参赛者根据资格赛和预赛、复赛的成绩，会
 * 有不同的积分。比赛采用锦标赛机制，分轮次进行，设某一轮有m个人参加，那么
 * 参赛者会被分为m/2组，每组恰好2人，m/2组的人分别厮杀，假定积分高的人肯定
 * 获胜，若积分一样，则随机产生获胜者，获胜者获得参加下一轮的资格，输的人被
 * 淘汰，重复这个过程，直至决出冠军，求参赛者最多可以到第几轮，初始为0轮。
 * 输入描述：
 * 第一行一个整数n(1<=n<=2^20),表示参加比赛的总人数。
 * 接下来n个数字表示每个参赛者的积分，小美是第一个参赛者。
 * 输出描述：小美最多参赛的轮次。
 * 输入：
 * 4
 * 4 1 2 3
 * 输出：
 * 2
 */
public class P3 {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] score = new int[n];
        for (int i=0;i<n;i++) {
            score[i] = scanner.nextInt();
        }
        int beauty = score[0];
        int lowerCounts = 0;
        int round = 0;
        for (int j=1;j<n;j++) {
            if (score[j] <= beauty) {
                lowerCounts++;
            }
        }
        while (lowerCounts > 0) {
            if (lowerCounts % 2 == 0) {
                lowerCounts = lowerCounts/2-1;
            } else {
                lowerCounts = lowerCounts/2;
            }
            round++;
        }
        System.out.println(round);
    }
}