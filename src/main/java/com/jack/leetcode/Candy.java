package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/5 22:30
 * LeetCode 135
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，
 * 老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * 例1:
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 例2:
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 */
public class Candy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(distributeCandy0(arr));
        System.out.println(distributeCandy1(arr));
    }
    private static int distributeCandy0(int[] ratings) {
        int[] A = new int[ratings.length];
        Arrays.fill(A, 1);
        for (int i = 1; i < ratings.length; i++)
            if (ratings[i] > ratings[i - 1])
                A[i] = A[i - 1] + 1;
        int sum = A[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && A[i] <= A[i + 1])
                A[i] = A[i + 1] + 1;
            sum += A[i];
        }
        return sum;
    }
    private static int distributeCandy1(int[] ratings) {
        int[] L = new int[ratings.length];
        int[] R = new int[ratings.length];
        Arrays.fill(L, 1);
        Arrays.fill(R, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                L[i] = L[i - 1] + 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                R[i] = R[i + 1] + 1;
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(L[i], R[i]);
        }
        return sum;
    }
}