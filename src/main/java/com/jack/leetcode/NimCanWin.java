package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/7 22:48
 * LeetCode 292
 * 你和你的朋友，两个人一起玩Nim游戏：桌子上有一堆石头，
 * 每次你们轮流拿掉1-3块石头。拿掉最后一块石头的人就是获胜者。
 * 你作为先手。你们是聪明人，每一步都是最优解。
 * 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
 * 输入: 4
 * 输出: false
 * 解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
 * 因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 */
public class NimCanWin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(canWin(n));
    }
    private static boolean canWin(int n) {
        int val = n % 4;
        if (val >= 1)
            return true;
        return false;
    }
}