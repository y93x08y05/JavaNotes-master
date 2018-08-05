package com.jack.duoduopin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jack on 8/4/2018 10:51 AM
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
public class Player1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String []s = sc.nextLine().split(" ");
        int n = Integer.valueOf(s[0]);
        int m = Integer.valueOf(s[1]);
        String []str = new String[m];
        for (int i=0;i<m;i++) {
            str[i] = sc.nextLine();
        }
        String [] newStr = new String[n];
        for (int i=0;i<n;i++) {
            char [] c = new char[m];
            for (int j=0;j<m;j++) {
                c[j] = str[j].charAt(i);
            }
            Arrays.sort(c);
            newStr[i] = new String(c);
        }
        int max = 0;
        for (int i=1;i<n;i++) {
            if (newStr[max].compareTo(newStr[i]) > 0) {
                max = i;
            }
            if (newStr[max].compareTo(newStr[i]) == 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(max);
    }
}
