package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/7 12:02
 * LeetCode 657
 * 在二维平面上，有一个机器人从原点 (0, 0) 开始。
 * 给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
 * 移动顺序由字符串表示。
 * 字符move[i]表示其第i次移动。
 * 机器人的有效动作有R（右），L（左），U（上）和 D（下）。
 * 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
 * 注意：机器人“面朝”的方向无关紧要。
 * “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。
 * 此外，假设每次移动机器人的移动幅度相同。
 * 例1:
 * 输入: "UD"
 * 输出: true
 * 解释：机器人向上移动一次，然后向下移动一次。
 * 所有动作都具有相同的幅度，因此它最终回到它开始的原点。因此返回true。
 * 例2:
 * 输入: "LL"
 * 输出: false
 * 解释：机器人向左移动两次。
 * 它最终位于原点的左侧，距原点有两次“移动”的距离。
 * 返回false，因为它在移动结束时没有返回原点。
 */
public class JudgeCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(ifReturnCircle(s));
    }
    private static boolean ifReturnCircle(String moves) {
        int len = moves.length();
        int sumHorizontal = 0;
        int sumVertical = 0;
        for (int n = 0; n < len; n++) {
            if (moves.charAt(n) == 'U')
                sumVertical++;
            if (moves.charAt(n) == 'D')
                sumVertical--;
            if (moves.charAt(n) == 'L')
                sumHorizontal--;
            if (moves.charAt(n) == 'R')
                sumHorizontal++;
        }
        if (sumHorizontal == 0 && sumVertical == 0)
            return true;
        return false;
    }
}