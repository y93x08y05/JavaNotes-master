package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jack
 * @Date: 2019/3/15 13:35
 * LeetCode 120
 * 给定一个三角形，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 动态规划问题求解
 */
public class Triangle {
    public static List<List<Integer>> lists = new ArrayList<>();
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);list3.add(5);list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);list4.add(1);list4.add(8);list4.add(3);
        lists.add(list1);lists.add(list2);lists.add(list3);lists.add(list4);
        System.out.println(new Triangle().minimumTotal1(lists));
        System.out.println(new Triangle().minimumTotal2(lists));
    }
    private int minimumTotal1(List<List<Integer>> triangle) {
        int row = triangle.size();
        if (row == 0)
            return 0;
        int[] res = new int[row + 1];
        for (int i = row - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j  = 0; j < list.size(); j++) {
                res[j] = Math.min(res[j + 1], res[j]) + list.get(j);
            }
        }
        return res[0];
    }
    private int minimumTotal2(List<List<Integer>> triangle) {
        int row = triangle.size();
        if (row == 0)
            return 0;
        int[][] res = new int[row][row];
        int minSum = Integer.MAX_VALUE;
        List<Integer> list0 = triangle.get(0);
        if (list0.size() == 0)
            return 0;
        if (row == 1)
            return list0.get(0);
        res[0][0] = list0.get(0);
        for (int i = 1; i < row; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (j == 0) {
                    res[i][j] = res[i-1][j] + list.get(j);
                } else if (j == list.size() - 1) {
                    res[i][j] = res[i - 1][j - 1] + list.get(j);
                } else {
                    res[i][j] = Math.min(res[i - 1][j - 1], res[i - 1][j]) + list.get(j);
                }
                if (i == row - 1) {
                    if (minSum > res[i][j]) {
                        minSum = res[i][j];
                    }
                }
            }
        }
        return minSum;
    }
}