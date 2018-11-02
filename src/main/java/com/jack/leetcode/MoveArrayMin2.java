package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 4:52 PM
 * LeetCode 462
 * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，
 * 其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。
 * 例：
 * 输入:
 * [1,2,3]
 * 输出:
 * 2
 * 说明：
 * 只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
public class MoveArrayMin2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(findMinMove(arr));
    }
    private static int findMinMove(int[] arr) {
        Arrays.sort(arr);
        int val = arr[arr.length / 2];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += Math.abs(val - arr[i]);
        }
        return res;
    }
}
