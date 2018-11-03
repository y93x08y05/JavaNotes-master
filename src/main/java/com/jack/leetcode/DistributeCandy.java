package com.jack.leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: Jack
 * @Date: 2018/9/8 21:38
 * LeetCode 575
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，
 * 每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。
 * 返回妹妹可以获得的最大糖果的种类数。
 * 例1:
 * 输入: candies = [1,1,2,2,3,3]
 * 输出: 3
 * 解析: 一共有三种种类的糖果，每一种都有两个。
 * 最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。
 * 这样使妹妹获得糖果的种类数最多。
 * 例2:
 * 输入: candies = [1,1,2,3]
 * 输出: 2
 * 解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，
 * 弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
 */
public class DistributeCandy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findSisterCandy(arr));
    }
    private static int findSisterCandy(int[] candy) {
        int count = candy.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < candy.length; i++) {
            set.add(candy[i]);
        }
        if (set.size() >= count)
            return count;
        return set.size();
    }
}