package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/6 16:34
 * LeetCode 673
 * 最长递增子序列的个数
 * 给定一个没有排序的整数数组，找到最长递增子序列的个数
 * 例1:
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 例2:
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 */
public class FindNumberOfLIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new FindNumberOfLIS().find0(arr));
        System.out.println(new FindNumberOfLIS().find1(arr));
    }
    public int find0(int []arr) {
       if (arr == null || arr.length == 0)
           return 0;
       int [][]cache = new int[arr.length][3];
       int maxLen = 0;
       int count = 0;
       for (int i = 0; i < arr.length; i++) {
           int []temp = {arr[i], 1, 1};
           for (int j = 0; j < i; j++) {
               if (cache[j][0] < arr[i] && cache[j][1] + 1 == temp[1])
                   temp[2] += cache[j][2];
               else if (cache[j][0] < arr[i] && cache[j][1] + 1 > temp[1]) {
                   temp[1] = cache[j][1] + 1;
                   temp[2] = cache[j][2];
               }
           }
           cache[i] = temp;
           if (maxLen == temp[1])
               count += temp[2];
           else if (maxLen < temp[1]) {
               count = temp[2];
               maxLen = temp[1];
           }
       }
       return count;
    }
    public int find1(int [] arr) {
        int n = arr.length;
        int max_len = 1;
        int res = 0;
        int [] dp = new int[n];
        int [] cnt = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    cnt[i] = cnt[j];
                } else if (arr[j] < arr[i] && dp[j] + 1 == dp[i]) {
                    cnt[i] += cnt[j];
                }
            }
            max_len = Math.max(max_len,dp[i]);
        }
        for (int i = 0; i < n; ++i) {
            if (dp[i] == max_len) {
                res +=cnt[i];
            }
        }
        return res;
    }
}