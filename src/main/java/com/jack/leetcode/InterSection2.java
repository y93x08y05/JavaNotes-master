package com.jack.leetcode;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/7 23:54
 * LeetCode 350
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 例1：
 * 输入： nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出： [2,2]
 * 例2：
 * 输入： nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 */
public class InterSection2 {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[]num2 = {2, 2};
        System.out.println(Arrays.toString(intersection(num1, num2)));
    }
    private static int[] intersection(int[] num1, int[] num2) {
        Arrays.sort(num1);
        Arrays.sort(num2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < num1.length && j < num2.length;) {
            if (num1[i] == num2[j]) {
                list.add(num1[i]);
                i++;
                j++;
            } else if (num1[i] < num2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}