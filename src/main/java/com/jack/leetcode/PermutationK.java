package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/6 9:29
 * LeetCode 60
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，
 * 当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class PermutationK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(findPermutation(n, k));
    }
    private static String findPermutation(int n, int k) {
        k--;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);
        int factorial = 1;
        for (int i = 2; i < n; i++)
            factorial *= i;
        int round = n - 1;
        StringBuilder sb = new StringBuilder();
        while (round >= 0) {
            sb.append(list.remove(k / factorial));
            k %= factorial;
            if (round != 0)
                factorial /= round;
            round--;
        }
        return sb.toString();
    }
}