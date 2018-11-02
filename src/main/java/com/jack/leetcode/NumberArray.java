package com.jack.leetcode;

/**
 * @Author: Jack
 * @Date: 2018/9/7 22:14
 * LeetCode 303
 * 给定一个整数数组num，求出数组从索引i到j(i ≤ j)
 * 范围内元素的总和，包含i,j两点。
 * 给定 num = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 */
public abstract class NumberArray {
    int[] val;
    public NumberArray(int[] num) {
        val = new int[num.length];
        if (val.length == 0)
            return;
        val[0] = num[0];
        for (int i = 1; i < num.length; i++) {
            val[i] = val[i-1] + num[i];
        }
    }
    public int sumRange(int i, int j) {
        if (val.length == 0)
            return 0;
        if (j > val.length - 1)
            j = val.length - 1;
        if (i <= 0)
            return val[j];
        return val[j] - val[i - 1];
    }
    public static void main(String[] args) {

    }
}