package com.jack.leetcode;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/10/6 20:03
 * LeetCode 523
 * 连续的子数组和
 * 给定一个包含非负数的数组和一个目标整数 k，
 * 编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，
 * 总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 * 例1:
 * 输入: [23,2,4,6,7], k = 6
 * 输出: True
 * 解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
 * 例2:
 * 输入: [23,2,6,4,7], k = 6
 * 输出: True
 * 解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 */
public class CheckSubArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new CheckSubArraySum().find(arr, k));
    }
    public boolean find(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0, -1);}};
        int runningSum = 0;
        for (int i = 0; i < arr.length; i++) {
            runningSum += arr[i];
            if (k != 0) runningSum %= k;
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) return true;
            }
            else map.put(runningSum, i);
        }
        return false;
    }
}