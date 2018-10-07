package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/7 14:42
 * LeetCode 55
 * 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * 例1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 例2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。
 * 但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class CanJump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new CanJump().find(arr));
    }
    public boolean find(int []arr) {
        int reach = arr[0];
        for (int i = 1; i < arr.length && reach >= i; i++) {
            if (i + arr[i] > reach)
                reach = i + arr[i];
        }
        return reach >= arr.length-1 ? true : false;
    }
}