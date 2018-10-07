package com.jack.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: Jack
 * @Date: 2018/10/7 9:26
 * LeetCode 532
 * 数组中的K-diff数对
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。
 * 这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，
 * 且两数之差的绝对值是 k.
 * 例1:
 * 输入: [3, 1, 4, 1, 5], k = 2
 * 输出: 2
 * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 * 例2:
 * 输入:[1, 2, 3, 4, 5], k = 1
 * 输出: 4
 * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 * 例3:
 * 输入: [1, 3, 1, 5, 4], k = 0
 * 输出: 1
 * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
 */
public class FindPairs {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(new FindPairs().find(arr, k));
    }
    public int find(int []arr,int k) {
        int len = arr.length,result = 0;
        Arrays.sort(arr);
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        if (k != 0) {
            for (int i = 0; i < len; i++) {
                if (!set1.contains(arr[i])&&set1.contains(arr[i]-k))
                    result++;
                set1.add(arr[i]);
            }
        } else {
            for (int i = 0; i < len; i++) {
                if (!set2.contains(arr[i])&&set1.contains(arr[i])) {
                    result++;
                    set2.add(arr[i]);
                }
                set1.add(arr[i]);
            }
        }
        return result;
    }
}