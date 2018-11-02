package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 4:18 PM
 * LeetCode 453
 * 最小移动次数使数组元素相等
 * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。
 * 每次移动可以使 n - 1 个元素增加 1。
 * 例:
 * 输入:
 * [1,2,3]
 * 输出:
 * 3
 * 解释:
 * 只需要3次移动（注意每次移动会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class MoveArrayMin1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(findMinMove(arr));
    }
    private static int findMinMove(int[] arr) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
            res += arr[i];
        }
        return res - min * arr.length;
    }
}
