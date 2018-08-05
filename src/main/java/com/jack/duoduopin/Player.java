package com.jack.duoduopin;

import java.util.Scanner;

/**
 * Created by Jack on 8/4/2018 9:35 AM
 * 拼多多2019秋招内推笔试-Java研发
 * 票选球王
 * 题目描述：四年一次的世界杯来了，小多在公司内发起了一个票选最强球星的活动
 * 一共有N个球星，每位投票者需要在选票上为每位候选球星评定一个等级，等级由英文
 * 字母表示，a最高，z级最低，共26级。
 * 当X评级比Y评级高的票数高于Y评级比X评级高的票数，则候选球星X比候选球星Y强
 * 根据此规则，最多只有一个球王，也可能没有球王。
 * 输入描述
 * 第一行包含两个整数N和M，分别表示候选球星数量以及选票数量。
 * 后边M行，每行是一个长度为N的字符串，每个字符串表示一张选票上的信息，每个字符串
 * 的第k个字符表示这张选票对第k个候选球星的评级。
 * 1<=N<=50 1<=M<=50 字符串值包含小写英文字母
 * 输出描述
 * 若有球王，则输出一行仅包含一个整数X，表示编号为X的候选球星是球王，若没有球王，
 * 则输出一行仅包含一个整数-1。
 * 输入：
 * 4 3
 * acbd
 * bacd
 * bdca
 * 输出
 * 0
 */
public class Player {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] str = sc.nextLine().split(" ");
        int N = Integer.valueOf(str[0]);
        int M = Integer.valueOf(str[1]);
        String [] strings = new String[M];
        for (int i=0;i<M;i++) {
            strings[i] = sc.nextLine();
        }
        System.out.println(getNumber(N, M, strings));
    }
    private static int getNumber(int N,int M,String [] strings) {
        int temp;
        boolean [][] flag = new boolean[N][N];
        for (int i=0;i<flag.length;i++) {
            flag[i][i] = true;
        }
        for (int q=0;q<strings[0].length()-1;q++) {
            for (int p=q+1;p<strings[0].length();p++) {
                temp = 0;
                for (int j=0;j<strings.length;j++) {
                    if (strings[j].charAt(q) < strings[j].charAt(p)) {
                        temp++;
                    }
                }
                if (temp>M/2) {
                    flag[q][p] = true;
                } else {
                    flag[p][q] = true;
                }
            }
        }
        for (int i=0;i<flag.length;i++) {
            boolean temp1 = true;
            int j = 0;
            while (j < flag[i].length) {
                if (temp1 & flag[i][j]) {
                    j++;
                } else {
                    temp1 = false;
                    break;
                }
            }
            if (temp1 == true)
                return i;
        }
        return -1;
    }
}
