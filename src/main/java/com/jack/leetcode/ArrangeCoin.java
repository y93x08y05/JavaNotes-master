package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/6 15:07
 * LeetCode 441
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，
 * 第 k 行就必须正好有 k 枚硬币。
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 * 例1:
 * n = 5
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * 因为第三行不完整，所以返回2.
 * 例2:
 * n = 8
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * 因为第四行不完整，所以返回3.
 * 最大行如果为m，则m满足m*(m+1)/2<=n
 * 等差数列求和公式 Sn=n(a1+an)/2
 * 在这个题中，a1 = 1 ，an = n ，所以用最大行公式进行求解
 * 二分查找的特征：
 * (1)二分查找基本上每次都会将范围降低为原来的一半
 * (2)二分查找需要建立在待查找数值具有次序的基础上
 */
public class ArrangeCoin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findMaxRow(n));
    }
    private static int findMaxRow(int n) {
        int start = 0;
        int end = n;
        int mid;
        while (start <= end) {
            mid = (start + end) >> 1;
            if ((0.5 * mid * mid + 0.5 * mid) <= n)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start - 1;
    }
}