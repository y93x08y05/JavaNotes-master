package com.jack.duoduopin;

import java.util.Scanner;

/**
 * Created by Jack on 8/3/2018 10:32 PM
 * 拼多多2019秋招内推笔试-Java研发
 * 复制可乐
 * 题目描述：自动售货机里有N瓶复制可乐、复制非常神奇，喝了他的人都会复制出一个自己，现在有
 * Alice、Bob、Cathy、Dave四个人在排队买复制可乐。买完的人会马上喝掉，然后他和他的副本会
 * 重新去最后排队买可乐。问最后一个买到复制可乐的人叫什么名字。
 * 输入描述：输入包含一个正整数N（1<=N<=1,000,000,000）,表示可乐的数量
 * 输出描述：输出最后一个喝复制可乐的人。
 * 输入：8
 * 输出：Bob
 */
public class Cola {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        getWho(n);
    }
    public static void getWho(int n) {
        int base = 4;
        int exp = 1;
        while (n > base*exp) {
            n = n - base*exp;
            exp = exp*2;
        }
        int num = 0;
        for (int i=1;i<5;i++) {
            for (int j=1;j<exp+1;j++) {
                num = num + 1;
                if (num == n) {
                    if (i == 1) {
                        System.out.println("Alice");
                    }
                    if (i == 2) {
                        System.out.println("Bob");
                    }
                    if (i == 3) {
                        System.out.println("Cathy");
                    }
                    if (i == 4) {
                        System.out.println("Dave");
                    }
                }
            }
        }
    }
}
